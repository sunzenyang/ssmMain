package com.szy.project.services;

import java.util.List;

import com.szy.project.entity.TreeTest;
import com.szy.project.entity.User;

/**
 * ²âÊÔ  
 * 
 * @author ËïÕñÑô  on 2016-06-11
 *
 */
public interface UserTestService {

	public List<User> findAll();

	public User getUserById(String userId);
	
	/**
	 * ²âÊÔÊ÷ Êı¾İ½Ó¿Ú
	 * @return
	 */
	public List<TreeTest> getTreeTest();




}
