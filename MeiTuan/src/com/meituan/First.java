package com.meituan;

import java.util.Scanner;

public class First {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        System.out.println(getSum(S,T));
    }

    public static int getSum(String sStr,String tStr){

        String sTem;

        int count = 0;

        for(int i=0;i<=(sStr.length()-tStr.length());i++){
            count += getDistance(sStr.substring(i,(i+tStr.length())),tStr);
        }

        return count;
    }

    public static int getDistance(String sIn,String tStr){

        int count = 0;

        for (int i=0;i<sIn.length();i++){
            if (sIn.charAt(i)!=tStr.charAt(i))
                count++;
        }

        return count;
    }

}
