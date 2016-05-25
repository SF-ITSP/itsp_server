package com.itsp.common.util;

import java.net.URL;

abstract class RequestServer<T> {

	public T request(URL url) {
		HttpConnection httpConnection = new HttpConnection();
		return requestCallBack(httpConnection.request(url));
	}

	abstract T requestCallBack(String result);
}
