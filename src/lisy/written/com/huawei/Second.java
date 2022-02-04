package lisy.written.com.huawei;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ns = new int[n];
        for (int i=0;i<n;i++){
            ns[i] = scanner.nextInt();
        }
        System.out.println(jump(ns));
    }

    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // write your code here
        if(A.length<=1){
            return 0;
        }
        int i=0,j=0;
        int count=0;
        while(i<A.length){
            if(i+A[i]>=A.length-1){
                count++;
                return count;
            }
            int temp=Integer.MIN_VALUE;
            for(int k=i+1;k<=i+A[i];k++){
                if(temp<k+A[k]){
                    temp=k+A[k];
                    j=k;
                }
            }
            i=j;
            count++;
        }
        return 0;
    }

}
