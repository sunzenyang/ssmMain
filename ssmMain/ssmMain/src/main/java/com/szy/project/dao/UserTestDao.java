package com.szy.project.dao;

import java.util.List;

import com.szy.project.entity.User;


/**
 * ≤‚ ‘  
 * @author ÀÔ’Ò—Ù  on 2016-06-11
 */
public interface UserTestDao {

	List<User> findAll();

	void save(User user);

	void update(User u);

	User getUserById(Integer userId);

}
