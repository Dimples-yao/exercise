package lisy.written.com.tencent;

import java.util.Scanner;

public class ZSSecond {

    /**
     * 判断构成k长度，需要几个a和b
     */
    public static long getResults(long kLength,long aLength,long aNums,long bLength,long bNums){
        long sum = 0;
        for (int i=0;i<=aNums;i++){
            for (int j=0;j<=bNums;j++){
                if (kLength == (i*aLength+j*bLength)){
                    sum+=getNums(aNums,i,bNums,j);
                }
            }
        }
        return sum;
    }

    /**
     * 判断当需要改数量的a和b时，会有多少种可能性。
     */
    public static long getNums(long aNums,long aNeeds,long bNums,long bNeeds){
        long a;
        long b;
        a = getNFactorial(aNums)/(getNFactorial(aNeeds)*getNFactorial(aNums-aNeeds));
        b = getNFactorial(bNums)/(getNFactorial(bNeeds)*getNFactorial(bNums-bNeeds));
        return a*b;
    }

    public static long getNFactorial(long n){
        if(n==0){
            return 1l;
        }
        return n*getNFactorial(n-1);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long kLength = scanner.nextLong();
        long aLength = scanner.nextLong();
        long aNums = scanner.nextLong();
        long bLength = scanner.nextLong();
        long bNums = scanner.nextLong();
        System.out.println(getResults(kLength,aLength,aNums,bLength,bNums)%1000000007);
    }
}
