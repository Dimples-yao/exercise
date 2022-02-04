package written.com.kuaishou;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        int res = 1;
        while (y > 0) {
            if ((y & 1) != 0)
                res = res * x % n;
            x = x * x % n;
            y >>= 1;
        }
        System.out.println(res);
    }
}