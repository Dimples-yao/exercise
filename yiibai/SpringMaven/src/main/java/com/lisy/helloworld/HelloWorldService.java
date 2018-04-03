package com.lisy.helloworld;

/**
 * Created by Lisy on 2017/5/5.
 */
public class HelloWorldService {

    private Helloworld helloworld;

    public HelloWorldService(){

    }

    public void setHelloworld(Helloworld helloworld){
        this.helloworld=helloworld;
    }
    public Helloworld getHelloworld(){
        return this.helloworld;
    }
}
