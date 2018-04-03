package com.lisy;

import com.lisy.helloworld.HelloWorldService;
import com.lisy.helloworld.Helloworld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lisy on 2017/5/5.
 */
public class HelloProgram {
    private String name;

    public static void main(String[] args){
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

        HelloWorldService service=(HelloWorldService) context.getBean("helloWorldService");

        Helloworld hw=service.getHelloworld();

        hw.sayHello();
    }

}
