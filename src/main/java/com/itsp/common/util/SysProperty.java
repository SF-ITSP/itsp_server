package com.itsp.common.util;

import java.io.IOException;
import java.util.Properties;

public class SysProperty {

	public static Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public static Properties instance() {
		SysProperty propertyUtil = new SysProperty();
		if (propertyUtil.getProperties() == null) {
			SysProperty.properties = new Properties();
			try {
				SysProperty.properties.load(propertyUtil.getClass()
						.getResourceAsStream("/sys.properties"));
			} catch (IOException e) {
			}
		}
		return SysProperty.properties;
	}
}
