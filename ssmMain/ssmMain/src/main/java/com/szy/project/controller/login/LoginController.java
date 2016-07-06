package com.szy.project.controller.login;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.szy.project.entity.TreeTest;
import com.szy.project.entity.User;
import com.szy.project.services.UserTestService;


/**
 * 登录 
 * 
 * @author 孙振阳  on 2016-06-11
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserTestService userService;
	
	/**
	 * 获取树节点所有根节点数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(){
		return "/login";
	}
	
	/**
	 * 获取树节点所有根节点数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signinPost", method = RequestMethod.POST)
	public String signinPost(HttpServletRequest request,HttpServletResponse response,User user){
		String  pathjsp="";
		if(user !=null){
			System.out.println("登录成功!");
			request.getSession().setAttribute("user", user); 
			List<User> findAll = userService.findAll();
			request.setAttribute("userList", findAll);
			pathjsp="/test/allUser";
		}else{
			System.out.println("登录失败!");
			pathjsp="/login";
		}
		return pathjsp;
	}



  
}
