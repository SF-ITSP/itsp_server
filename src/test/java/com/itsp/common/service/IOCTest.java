package com.itsp.common.service;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.SessionFactionAutowiring;

public class IOCTest extends ItspJUnit4ClassRunner {
	@Autowired
	private ApplicationContextTest applicationContext;

	@Test
	public void APPLICATION_CONTEXT_IS_RUNNING() {
		Assert.assertNotNull("�����ļĴ������Ϊ��", applicationContext);
		Assert.assertNotNull("�����Ĳ���Ϊ��",
				applicationContext.getApplicationContext());
	}
	@Test
	public void BEAN_IS_INIT() {
		Assert.assertNotNull("bean �����¼�Ϊ�ɹ���ʼ��", applicationContext
				.getApplicationContext()
				.getBean(SessionFactionAutowiring.class));
	}
}
