package com.lisy.helloworld.impl;

import com.lisy.helloworld.Helloworld;

/**
 * Created by Lisy on 2017/5/5.
 */
public class StrutsHelloWorld implements Helloworld{
    @Override
    public void sayHello(){
        System.out.println("Struts Say Hello!!");
    }
}
