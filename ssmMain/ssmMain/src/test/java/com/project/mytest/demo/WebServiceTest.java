package com.project.mytest.demo;
import javax.xml.ws.Endpoint;

import com.szy.project.services.impl.WebServiceTestServiceImpl;



public class WebServiceTest {
	 
    
    public static void main(String[] args) {
    	String address="http://localhost:8888/aabb";
    	Endpoint.publish(address, new WebServiceTestServiceImpl());
	}
    
    
    

}
