package com.itsp.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.itsp.common.CommonException;

public class HttpConnection {

	public String request(URL url) {
		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setConnectTimeout(1000*60*30);
			httpURLConnection.setReadTimeout(1000*60*30);
			InputStream inputStream = httpURLConnection.getInputStream();
			return InputStreamUtil.toString(inputStream);
		} catch (IOException e) {
			throw new CommonException(e.getMessage());
		}
	}
}
