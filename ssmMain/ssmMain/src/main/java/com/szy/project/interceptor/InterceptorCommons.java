package com.szy.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorCommons extends HandlerInterceptorAdapter{
	
		/**  
	     * ��ҵ��������������֮ǰ������  
	     * �������false  
	     *     �ӵ�ǰ������������ִ��������������afterCompletion(),���˳��������� 
	     * �������true  
	     *    ִ����һ��������,ֱ�����е���������ִ�����  
	     *    ��ִ�б����ص�Controller  
	     *    Ȼ�������������,  
	     *    �����һ������������ִ�����е�postHandle()  
	     *    �����ٴ����һ������������ִ�����е�afterCompletion()  
	     */    
	    @Override    
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {     
	        String requestUri = request.getRequestURI();  
	        String contextPath = request.getContextPath();  
	        String url = requestUri.substring(contextPath.length());  
	        
	          
	        String user =  (String)request.getSession().getAttribute("user");   
	        if(user == null){  
	            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);  
	            return false;  
	        }else  
	            return true;     
	    }    
	    
	    /** 
	     * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���    
	     * ����modelAndView�м������ݣ����統ǰʱ�� 
	     */  
	    @Override    
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {       
	        if(modelAndView != null){  //���뵱ǰʱ��    
	            modelAndView.addObject("var", "����postHandle");    
	        }    
	    }    
	    
	    /**  
	     * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��   
	     *   
	     * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()  
	     */    
	    @Override    
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {    
 
	    }    


}
