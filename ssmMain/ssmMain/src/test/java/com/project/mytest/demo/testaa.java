package com.project.mytest.demo;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class testaa {

	public static void main(String[] args) {
		//ɾ���ļ�;
		File file = new File("F:/�½��ļ���/123.txt ");
		// ·��Ϊ�ļ��Ҳ�Ϊ�������ɾ��
		if (file.isFile() && file.exists()) {
			System.out.println("111111111111111");
			file.delete();
		}
		

		
		
	}
	
	public void aa(HttpServletRequest request){
		 
	}

}
