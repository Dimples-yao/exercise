package written.com.newcoder;
import java.util.Scanner;

public class First{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        int n1 = str1.length();
        int n2 = str2.length();
        if(n1 < 1 || n2 < 1) {
            System.out.println(0);
            return;
        }
        int temp[][] = new int[n1][n2];
        int longest = 0;
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        for(int i = 0; i < n1; i++) {
            for(int j = 0;j <n2;j++){
                temp[i][j] = 0;
            }
        }
        for(int i = 0;i < n1;i++){
            if(char1[i] == char2[0])
                temp[i][0] = 1;
        }
        for(int i = 0;i < n2;i++){
            if(char1[0] == char2[i])
                temp[0][i] = 1;
        }
        for(int i = 1; i < n1;i++) {
            for(int j = 1; j<n2;j++){
                if (char1[i] == char2[j]){
                    temp[i][j] = temp[i-1][j-1] +1;
                }
            }
        }
        for(int i = 0; i < n1;i++) {
            for(int j = 0; j<n2;j++) {
                if(temp[i][j] > longest)
                    longest = temp[i][j];
            }
        }
        System.out.println(longest);
    }
}