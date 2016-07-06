package com.project.mytest.demo;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.szy.project.services.WebServiceTestService;

public class TestCount {
	
	@BeforeClass  
    public static void setUpBeforeClass(){  
        System.out.println("=====static init=======");  
    }  
      
    @AfterClass  
    public static void tearDownAfterClass(){  
        System.out.println("=====static destory=======");  
    }  
      
    @Before  
    public void setUp(){  
        System.out.println("=======@before=======");  

    }  
      
    @After  
    public void tearDown(){  
        System.out.println("=======@after=======");  
    }  
      
    //客户端webService测试
    @Test  
    public void WebServiceClienttestAdd() throws Exception{  
    	//创建访问wsdl服务器地址的url
    	URL u=new URL("http://localhost:8888/aabb?wsdl");
    	//通过Qname指明服务器的具体信息
    	QName qn=new QName("http://impl.services.project.szy.com/", "WebServiceTestServiceImplService");
    	Service ser=Service.create(u, qn);
    	WebServiceTestService s=ser.getPort(WebServiceTestService.class);
    	System.out.println(s.add(2, 4));
    }  

    @Test  
    public void testhaha(){  
  
    	System.out.println("=======@Test2222222222222222222222=======");  
    } 
    

}
