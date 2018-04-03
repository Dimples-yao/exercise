package com.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        System.out.println(getAllSet(numbers));
    }

    /**
     * 得到所有可能组成的数，并放入到set数组中
     */
    public static int getAllSet(String numbers){
        int[] number = new int[numbers.length()];

        for (int i=0;i<numbers.length();i++){
            number[i] = numbers.charAt(i);
        }

        Set<Integer> allNumber = new HashSet<>();
        int[] smalls = new int[allNumber.size()];
        int i = 0;
        for (int tem:allNumber){
            smalls[i] = getSmall(tem);
        }



        return 0;
    }

    public static int getAll(int[] numbers){
        if (numbers.length==1){
            return numbers[0];
        }

        int count = 0;

        for (int i=0;i<numbers.length;i++){
            count= (int) (numbers[0]*Math.pow(10,numbers.length));
            int[] tem = new int[numbers.length-1];
            for (int j=0;j<tem.length;j++){
                tem[j] = numbers[j+1];
            }
            count+=getAll(tem);
        }

        return count;

    }

    /**
     * 求出最小的数
     */
    public static int getSmall(int theNumber){
        int count = 0;

        boolean flag = true;
        int i=0;
        while (flag){
            if (i<theNumber){
                count = i;
                flag = false;
            }
            i++;
        }
        return count;
    }

    /**
     * 求阶乘
     */
    public static int getNFactorial(int n){
        if(n==0){
            return 1;
        }
        return n*getNFactorial(n-1);
    }

}
