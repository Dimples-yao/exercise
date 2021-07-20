package java.written.com.tencent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ZSFirst {
    public static int getNums(int n,int m){
        if (n%(2*m)!=0)
            return 0;
        int sum = 0;
        boolean tag = false;
        for (int i=0;i<(n/m);i++){
            for (int j=1;j<=m;j++){
                if (!tag){
                    sum-=(m*i+j);
                }else {
                    sum+=(m*i+j);
                }
            }
            tag = (!tag);
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Date day=new Date();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(df.format(day));
        System.out.println(getNums(n,m));
        Date dayNew=new Date();
        System.out.println(df.format(dayNew));
    }

}
