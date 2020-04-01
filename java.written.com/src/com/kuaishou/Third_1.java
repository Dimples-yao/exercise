package com.kuaishou;

import java.util.Scanner;

public class Third_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = sc.nextInt();
        getResutl(str,index);
    }

    public static void getResutl(String str,int index){
        if (index ==0){
            System.out.println(str);
            return;
        }
        char[] cs = str.toCharArray();
        char[] result = new char[cs.length];
        for (int i = 0; i < index; i++) {
            result[i] = cs[cs.length-index+i];
        }
        for (int i = index; i < cs.length; i++) {
            result[i] = cs[i-index];
        }
        System.out.println(result);
    }

}
