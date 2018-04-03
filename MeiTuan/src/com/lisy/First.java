package com.lisy;

import java.util.Scanner;

public class First {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(zillionaire(n));
    }

    public static int zillionaire(int n){
        if (n<1 || n>6){
            return 0;
        }

        int count = 0;

        if (n==1){
            count = 1;
        }else if(n==2){
            count = 2;
        }else {
            for (int i = 1; i < n; i++) {
                count+=zillionaire(n-i);
            }
            count++;
        }
        return count;

    }
}
