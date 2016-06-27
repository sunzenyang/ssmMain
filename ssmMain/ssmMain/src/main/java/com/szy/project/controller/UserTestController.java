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
 * ����  
 * 
 * @author ������  on 2016-06-11
 *
 */

@Controller
@RequestMapping("/test/user")
public class UserTestController {
	
	@Autowired
	private UserTestService userService;
	
	/**
	 * ��ȡ�����û��б�
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
	 * ͨ��ID��ȡ�û�
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
	 * ͨ��ID��ȡ�û�
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
	public void toAddUser(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException{
		
		request.setAttribute("111", 1111);
		
		//ת������ӭҳ��
		request.getRequestDispatcher("/").forward(request, response); 
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * ���ƶ���APP �������� (�������ֻ�APP)
	 * ����json
	 */
	@RequestMapping("/getAPPIndex")
	public void getAPPIndex(HttpServletRequest request , HttpServletResponse response){
		BackInfoEntity back= new BackInfoEntity();   
		Gson gson = new Gson();
		//��ȡ�����json��
		//��json�� ת����ʵ��
		String userStr= request.getParameter("user");
		User u = gson.fromJson(userStr, User.class);
		
		
		//��������
		User user=new User();
		user.setName("zhangshan");
		user.setAge(13);
		user.setSex("Ů");
		user.setAddress("���� ��ƽ");
		
		String str="";
		try {
			//ҵ����
			if(user != null){
				//�ɹ�
				back.setCode("1");
				back.setResult(user);
			}else{
				back.setCode("0");
				back.setMsg("û��û������");
			}

		} catch (Exception e) {
			back.setCode("-1");
			back.setMsg("�쳣��" + e.getMessage());
		}finally{
			//������ת����json����
			str=gson.toJson(back);
			ResponseUtils.renderJson(response, str);
		}

	}
	
	
	
  
}
