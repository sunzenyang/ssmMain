package com.szy.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szy.project.dao.UserTestDao;
import com.szy.project.entity.User;
import com.szy.project.services.UserTestService;

/**
 * 测试  
 * @author 孙振阳  on 2016-06-11
 */
@Service
@Transactional
public class UserTestServiceImpl implements UserTestService{

	@Autowired
	private UserTestDao userDao;

	
	/**
	 * 测试 事物   
	 */
	public List<User> findAll(){
		System.out.println("qqqqqqqqqqqqq");
		User u=new User();
		u.setId(1);
		u.setName("撒旦撒倒萨大");
		u.setAge(22);
		userDao.update(u);
		
		User user=new User();
		user.setName("zhangshan");
		user.setAge(36);
		user.setSex("哈");
		user.setAddress("深证");
		userDao.save(user);

		System.out.println("qqqqqqqqqqqqq");
		List<User> userList=userDao.findAll();
		for (int i = 0; i < userList.size(); i++) {
			System.err.println(userList.get(i).getName());
		}
		
		return userList;
	}

	/**
	 * 测试 查询数据表为null时的处理
	 */
	public User getUserById(String userId) {
		System.out.println(Integer.valueOf(userId));
		//没数据返回 null
		User user=userDao.getUserById(Integer.valueOf(userId));
		System.out.println(user.getClass());
		return user;
	}



}
