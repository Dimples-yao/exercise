package com.lisy;

import java.util.Arrays;
import java.util.Scanner;

public class Second {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getMoney(n));
    }

    public static int getMoney(int n){

        int[] coins = {1,5,10,20,50,100};
        long dp[][] = new long[coins.length][n+1];

        Arrays.fill(dp[0],1);

        for (int i=coins.length-1;i>0;i--){
            if (n>=coins[i]){
                int m = (n+1)/coins[i];
                for (int j=n+1;j>0;j--){
                    for (int k=0;k<m;k++){

                    }
                }
            }
        }

        return 0;
    }

}
