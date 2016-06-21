package com.szy.project.entity.common;

/**
 * @author 孙振阳  on 2016-06-11
 * 
 * 通用消息工具类
 * 		                       包含：
 * 			   		     错误编码	
 * 					     错误信息	
 * 					     成功后返出数据
 * 
 */
public class BackInfoEntity {

	private String code ;			//错误编码 
	private String msg ;			//错误信息
	private Object result ;			//成功后返出数据
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
