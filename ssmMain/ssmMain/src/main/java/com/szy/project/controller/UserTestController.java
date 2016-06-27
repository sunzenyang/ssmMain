package com.szy.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.szy.project.entity.User;
import com.szy.project.entity.common.BackInfoEntity;
import com.szy.project.services.UserTestService;
import com.szy.project.utils.ResponseUtils;

/**
 * 测试  
 * 
 * @author 孙振阳  on 2016-06-11
 *
 */

@Controller
@RequestMapping("/test/user")
public class UserTestController {
	
	@Autowired
	private UserTestService userService;
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request){
		
		List<User> findAll = userService.findAll();
		request.setAttribute("userList", findAll);
		return "/test/allUser";
	}
	
	/**
	 * 通过ID获取用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public String getUserById(HttpServletRequest request , String userId){
		
		User user = userService.getUserById(userId);
		request.setAttribute("user", user);
		return "/test/allUser";
	}
	
	/**
	 * 通过ID获取用户
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
	public void toAddUser(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("111", 1111);
		
		//转发到欢迎页面
		request.getRequestDispatcher("/").forward(request, response); 
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * 向移动端APP 返回数据 (适用于手机APP)
	 * 反回json
	 */
	@RequestMapping("/getAPPIndex")
	public void getAPPIndex(HttpServletRequest request , HttpServletResponse response){
		BackInfoEntity back= new BackInfoEntity();   
		Gson gson = new Gson();
		//获取传入的json串
		//将json串 转换成实体
		String userStr= request.getParameter("user");
		User u = gson.fromJson(userStr, User.class);
		
		
		//测试数据
		User user=new User();
		user.setName("zhangshan");
		user.setAge(13);
		user.setSex("女");
		user.setAddress("北京 昌平");
		
		String str="";
		try {
			//业务处理
			if(user != null){
				//成功
				back.setCode("1");
				back.setResult(user);
			}else{
				back.setCode("0");
				back.setMsg("没有没有数据");
			}

		} catch (Exception e) {
			back.setCode("-1");
			back.setMsg("异常：" + e.getMessage());
		}finally{
			//将数据转换成json反出
			str=gson.toJson(back);
			ResponseUtils.renderJson(response, str);
		}

	}
	
	
	
  
}
