package lisy.written.com.PinDuoDuo;

import java.util.ArrayList;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//共有n个球员
        int m = scanner.nextInt();//共有m行,一共有m个人投票
        scanner.nextLine();
        ArrayList<String> qute = new ArrayList<>();
        while (scanner.hasNext())
            qute.add(scanner.nextLine());
        System.out.println(getKingBool(n,m,qute));
    }
    public static int getKingBool(int n,int m,ArrayList<String> qute){
        int[][] result = new int[n][n];
        for (int i = 0; i < m; i++) {
            oneQute(result,qute.get(i));
        }
        int[] allBool = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                allBool[i] += result[i][j];
            }
        }
        boolean tag = false;
        int theBoolPeople=0;
        int max = allBool[0];
        for (int i = 0; i < n; i++) {
            if (allBool[i]>max){
                max = allBool[i];
                theBoolPeople=i;
                tag=true;
            }
            if (allBool[i]==max)
                tag=false;
        }
        if (tag)
            return theBoolPeople;
        return -1;
    }

    public static int[][] oneQute(int[][] result,String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i)>str.charAt(j)){
                    result[i][j]++;
                    result[j][i]--;
                }
                else if (str.charAt(i)<str.charAt(j)){
                    result[i][j]--;
                    result[j][i]++;
                }
            }
        }
        return result;
    }

}
