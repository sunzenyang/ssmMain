package com.szy.project.entity.common;

/**
 * @author ������  on 2016-06-11
 * 
 * ͨ����Ϣ������
 * 		                       ������
 * 			   		     �������	
 * 					     ������Ϣ	
 * 					     �ɹ��󷵳�����
 * 
 */
public class BackInfoEntity {

	private String code ;			//������� 
	private String msg ;			//������Ϣ
	private Object result ;			//�ɹ��󷵳�����
	
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
