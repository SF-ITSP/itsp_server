package com.itsp.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.itsp.common.CommonException;

public class InputStreamUtil {
	public static  String toString(InputStream stream){
		StringBuffer buffer = new StringBuffer();
		String tmp = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
			while((tmp = reader.readLine())!=null){
				buffer.append(tmp);
			}
		} catch (IOException e) {
			throw new CommonException(e.getMessage());
		}
		return buffer.toString();
	}

}
