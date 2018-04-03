import com.lisy.First;

import java.util.Arrays;

public class Test {

    /**
     * https://www.nowcoder.com/question/next?pid=5583018&qid=105231&tid=14367091
     */

    public static void main(String[] args){
        long dp[][] = new long[10][10];
        Arrays.fill(dp[0],1);
        System.out.println(dp.length);
        System.out.println(dp[0].length);
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
                System.out.println(dp[i][j]);
            }
        }
    }
}
