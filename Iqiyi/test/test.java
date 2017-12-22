import java.util.Scanner;

/**
 * Created by NEUNB_Lisy on 2017/12/21.
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = sc.nextLong();
        long r=sum ,l=0;
        Boolean flag=false;
        while (l<(r-1)){
            long mid = (l+r)/2;
            if(getResult(mid)==sum){
                System.out.println(mid);
                flag =true;
                break;
            }else if(getResult(mid)<sum){l=mid;}
            else { r=mid;}
        }
        if (getResult(l)==sum){
            System.out.println(l);
        }
        else if(getResult(r)==sum){
            System.out.println(r);
        }
        else if(!flag){
            System.out.println(-1);
        }
        /*Scanner sc = new Scanner(System.in);
        long sum = sc.nextLong();
        boolean tag = true;
        long l = 0,r = sum;
        if (sum ==0){
            System.out.println(0);
        }else {
            while (l<(r)){
                long mid = (r+l)/2;
                if (sum == getResult(mid)){
                    System.out.println(mid);
                    tag = false;
                    break;
                }else if (sum>getResult(mid)){
                    l=mid;
                }else {
                    r = mid;
                }
            }
        }
        if(tag) {
            System.out.println(-1);
        }*/

    }

    public static long getResult(long x){
        long result=0;
        while (x!=0){
            result+=x;
            x = x/10;
        }
        return result;
    }
}
