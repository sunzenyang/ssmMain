package com.project.mytest.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
      
    @Test  
    public void testAdd(){  
    	System.out.println("=======@Test111111111111111111111=======");  
    }  

    @Test  
    public void testhaha(){  
    	System.out.println("=======@Test2222222222222222222222=======");  
    } 
    

}
