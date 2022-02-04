package written.com.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second {
    public static void getNums(int n,int k){
        int[][] result = new int[n][n];
        int count =0;
        for (int x=0;x<n;x++){
            for (int y=0;y<n;y++){
                if (result[x][y]==0){
                    if ((x+1)%(y+1)>=k){
                        result[x][y]=1;
                        count++;
                        if ((y+1)%(x+1)>=k){
                            result[y][x] =1;
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }

    public static void main(String[] args){
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        try {
            String nk = bf.readLine();
            String[] nks = nk.split(" ");
            int n = Integer.parseInt(nks[0]);
            int k = Integer.parseInt(nks[1]);
            getNums(n,k);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
