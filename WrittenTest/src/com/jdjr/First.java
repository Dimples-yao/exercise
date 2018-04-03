package com.jdjr;

import com.jdjr.model.User;

public class First {
    public static void main(String[] args){
        Integer[] i = {0,1};
        User[] users = new User[2];
        users[0].setName("lisy");
        users[0].setAge(22);
        users[0].setSex("男");
        users[1].setName("wy");
        users[1].setSex("女");
        users[1].setAge(22);
        System.out.println(users[0].getName());
        System.out.println(users[0].getSex());
        System.out.println(users[0].getAge());
    }
}
