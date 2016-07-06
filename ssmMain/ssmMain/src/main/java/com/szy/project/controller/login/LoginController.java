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
 * ��¼ 
 * 
 * @author ������  on 2016-06-11
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserTestService userService;
	
	/**
	 * ��ȡ���ڵ����и��ڵ�����
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(){
		return "/login";
	}
	
	/**
	 * ��ȡ���ڵ����и��ڵ�����
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signinPost", method = RequestMethod.POST)
	public String signinPost(HttpServletRequest request,HttpServletResponse response,User user){
		String  pathjsp="";
		if(user !=null){
			System.out.println("��¼�ɹ�!");
			request.getSession().setAttribute("user", user); 
			List<User> findAll = userService.findAll();
			request.setAttribute("userList", findAll);
			pathjsp="/test/allUser";
		}else{
			System.out.println("��¼ʧ��!");
			pathjsp="/login";
		}
		return pathjsp;
	}



  
}
