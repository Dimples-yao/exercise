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
            if(getSum(mid)==sum){
                System.out.println(mid);
                flag =true;
                break;
            }else if(getSum(mid)<sum){l=mid;}
            else { r=mid;}
        }
        if (getSum(l)==sum){
            System.out.println(l);
        }
        else if(getSum(r)==sum){
            System.out.println(r);
        }
        else if(!flag){
            System.out.println(-1);
        }
    }

    private static long getSum(long a) {
        long sum=0;
        while(a!=0){
            sum+=a;
            a/=10;
        }
        return sum;
    }
}
