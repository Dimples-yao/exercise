package com.kuaishou;

import java.math.BigInteger;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        scanner.close();
        String tem = nums[0];
        for (int i = 1; i < Integer.valueOf(nums[1]); i++) {
            tem = multiply(nums[0],tem);
        }

        BigInteger num=BigInteger.valueOf(Long.parseLong(tem));
        BigInteger num1[] = //remermber
                num.divideAndRemainder((BigInteger.valueOf(Long.parseLong(nums[2]))));
        System.out.println(num1[1]);

    }

    public static String ramainder(String dividend, String dividor) {
        return null;
    }


    public static String multiply(String num1, String num2) {
        int l = num1.length();
        int r = num2.length();
        int[] num = new int[l+r];
        for(int i=0;i<l;i++) {
            int n1=num1.charAt(l-1-i)-'0';
            int tmp=0;
            for(int j=0;j<r;j++) {
                int n2=num2.charAt(r-1-j)-'0';
                tmp=tmp+num[i+j]+n1*n2;
                num[i+j]=tmp%10;
                tmp/=10;
            }
            num[i+r]=tmp;
        }

        int i=l+r-1;
        while(i>0&&num[i]==0){
            i--;
        }
        String result = "";
        while(i>=0) {
            result+=(num[i--]);
        }
        return result;
    }
}
