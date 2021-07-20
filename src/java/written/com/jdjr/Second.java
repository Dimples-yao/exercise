package java.written.com.jdjr;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {

    public static int[] getXY(int xy){
        int[] xys = {0,0};
        if (xy%2==0){
            for (int i=2;i<xy;i=i*2){
                if (xy/i%2==1){
                    xys[0] = i;
                    xys[1] = xy/i;
                    return xys;
                }
            }
            return xys;
        }else {
            return xys;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] xys = new int[n];
        for (int i=0;i<n;i++){
            xys[i] = scanner.nextInt();
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i=0;i<xys.length;i++){
            list.add(getXY(xys[i]));
        }
        for (int[] i:list){
            if (i[0]!=0){
                System.out.println(i[1]+" "+i[0]);
            }else System.out.println("No");
        }
    }
}
