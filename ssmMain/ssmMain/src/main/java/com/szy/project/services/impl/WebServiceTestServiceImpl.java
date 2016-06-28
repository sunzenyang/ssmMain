package com.szy.project.services.impl;

import javax.jws.WebService;

import com.szy.project.services.WebServiceTestService;

/**
 * WebService   ---   Demo
 * @author sunzhenyang  on 2016-06-27
 *
 */


/**
 *  @WebService����д     ע���עΪWebService�ӿ�ʵ��
 *  endpointInterface=��ʵ�ֵĽӿ�·����
 *
 */
@WebService(endpointInterface="com.szy.project.services.WebServiceTestService")
public class WebServiceTestServiceImpl implements WebServiceTestService {

	public long add(long a, long b) {
		System.out.println("add="+(a+b));
		return a+b;
	}

	public long jian(long a, long b) {
		System.out.println("jian="+(a-b));
		return a-b;
	}

}
