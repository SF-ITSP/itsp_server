package com.itsp.common.util;

import java.io.ByteArrayInputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.itsp.common.CommonException;
import com.itsp.common.entity.MapRoute;

public class MapRouteRequestServer extends RequestServer<MapRoute> {

	@Override
	MapRoute requestCallBack(String result) {
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new ByteArrayInputStream(result
					.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new CommonException("解析错误!");
		}
		Element root = document.getRootElement();
		Node durationNode = root.selectSingleNode("duration");
		Node distanceNode = root.selectSingleNode("distance");
		MapRoute mapRoute= new MapRoute();
		String distanceText = distanceNode.getText();
		if(!"".equals(distanceText)){
			mapRoute.setDistance(Float.valueOf(distanceText));
		}
		String durationText = durationNode.getText();
		if(!"".equals(durationText)){
			mapRoute.setDuration(Float.valueOf(durationText));
		}
		return mapRoute;
	}

	public MapRoute request(Float lon1, Float lat1, Float lon2, Float lat2) {
		try {
			String mapServerPath = SysProperty.instance().getProperty("MAP_SERVER_URL");
			StringBuffer buffer = new StringBuffer(mapServerPath);			
			buffer.append("?&orig=%f,%f&dest=%f,%f&style=2&all=1&encode=UTF-8&customer=2.xml");
			String path = String.format(buffer.toString(), lon1, lat1, lon2, lat2);
			URL url = new URL(path);
			return request(url);
		} catch (Exception e) {
			throw new CommonException(e.getMessage());
		}
	}
}
