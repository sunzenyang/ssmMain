package com.project.mytest.demo;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class testaa {

	public static void main(String[] args) {
		//删除文件;
		File file = new File("F:/新建文件夹/123.txt ");
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			System.out.println("111111111111111");
			file.delete();
		}
		

		
		
	}
	
	public void aa(HttpServletRequest request){
		 
	}

}
