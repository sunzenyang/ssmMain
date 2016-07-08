package com.szy.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szy.project.entity.TreeTest;
import com.szy.project.services.UserTestService;


/**
 * 测试  ztree 插件使用 ，，返回json串
 * 
 * @author 孙振阳  on 2016-06-11
 */
@Controller
@RequestMapping("/TreeTest")
public class TreeTestController {
	
	@Autowired
	private UserTestService userService;
	
	/**
	 * 获取树节点所有根节点数据
	 * @param request
	 * @return
	 */
	@RequestMapping("/loadTreeParents")
	public String loadTreeParents(HttpServletRequest request){
		
		List<TreeTest> treeTestList= userService.getTreeTest();
		this.fenjie(treeTestList);
		request.setAttribute("jsonstr",this.fenjie(treeTestList));
		System.out.println(this.fenjie(treeTestList));
		return "/treeTest";
	}

	
	private String fenjie(List<TreeTest> tl) {
		StringBuffer strjson=new StringBuffer("[");
		String str="";
		String strwanmei="";
		if(tl != null){
			for (int i = 0; i < tl.size(); i++) {
				String depar=tl.get(i).getDepartment().toString();
				String [] splStr=depar.split("/");
				if(splStr!=null){
					//strjson.append("{id:"1", pId:"0", title:"hdasjdhasjhd", name:"北京"},");
					str+=this.chuan(splStr,depar,0,0);
				}
			}
			str.substring(1, str.length()-1);
			strwanmei=str.substring(1, str.length());
			
		}
		strjson.append(strwanmei+"]");
		return strjson.toString();
		
	}

	StringBuffer sb;
	private String chuan(String[] splStr,String str, int benci,int shang) {
		if(benci == 0  && shang == 0 ){
			sb=new StringBuffer("");
		}
		
			int bj=0; //本次迭代变量
			int bja=0; //上一次迭代变量
			if(benci < splStr.length){
				for (int i = benci; i < splStr.length; i++) {
					if(i==0){
						sb.append(",{\"id\":\""+splStr[i]+"\", \"pId\":\"0\", \"title\":\""+str+"\", \"name\":\""+splStr[i]+"\"}");	
					}
					if(i!=0 && benci > shang){
						sb.append(",{\"id\":\""+splStr[i]+"\", \"pId\":\""+splStr[shang]+"\", \"title\":\""+str+"\", \"name\":\""+splStr[i]+"\"}");
					}
					bj=i+1;
					bja=i;
					break;
				}
			
				this.chuan(splStr,str,bj,bja);
			}
			
			return sb.toString();

	}
	

  
}
