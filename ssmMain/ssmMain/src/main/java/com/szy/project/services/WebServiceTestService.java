package com.szy.project.services;

import javax.jws.WebService;


/**
 * WebService   ---   Demo
 * @author sunzhenyang  on 2016-06-27
 *
 */


// @WebService必须写     注解标注为WebService接口

@WebService
public interface WebServiceTestService {

	
	public long add(long a,long b);
	
	public long jian(long a, long b);
}
