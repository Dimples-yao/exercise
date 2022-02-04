package written.com.tencent;


import java.util.Scanner;

public class First {
    public static String isZfx(int[] xs,int[] ys){

        int[][] allxy = new int[4][2];

        for (int i=0;i<xs.length;i++){
            allxy[i][0] = xs[i];
            allxy[i][1] = ys[i];
        }

        int[] results = new int[6];

        results[0] = (int) (Math.pow(Math.abs(allxy[0][0]-allxy[1][0]),2) + Math.pow(Math.abs(allxy[0][1]-allxy[1][1]),2));
        results[1] = (int) (Math.pow(Math.abs(allxy[0][0]-allxy[2][0]),2) + Math.pow(Math.abs(allxy[0][1]-allxy[2][1]),2));
        results[2] = (int) (Math.pow(Math.abs(allxy[0][0]-allxy[3][0]),2) + Math.pow(Math.abs(allxy[0][1]-allxy[3][1]),2));
        results[3] = (int) (Math.pow(Math.abs(allxy[1][0]-allxy[2][0]),2) + Math.pow(Math.abs(allxy[1][1]-allxy[2][1]),2));
        results[4] = (int) (Math.pow(Math.abs(allxy[1][0]-allxy[3][0]),2) + Math.pow(Math.abs(allxy[1][1]-allxy[3][1]),2));
        results[5] = (int) (Math.pow(Math.abs(allxy[2][0]-allxy[3][0]),2) + Math.pow(Math.abs(allxy[2][1]-allxy[3][1]),2));


        int first = results[0];
        int second = results[0];



        for (int i=0;i<results.length;i++){
            if (first < results[i]){
                first = results[i];
            }
        }

        for (int i=0;i<results.length;i++){
            if (second < results[i]&& first != second){
                second = results[i];
            }
        }

        int[] smalls = new int[4];
        int j =0;
        for (int i=1;i<results.length;i++){
            if (results[i]!=first && results[i]!=second){
                smalls[j] = results[i];
                j++;
            }
        }

        if (smalls[0]==smalls[1] && smalls[1]==smalls[2] && smalls[2]==smalls[3]){
            return "Yes";
        }

        return "No";
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x=0;
        x = scanner.nextInt();

        for (int i=0;i<x;i++){
            String xString = scanner.nextLine();
            String yString = scanner.nextLine();
            String[] xs = xString.split(" ");
            String[] ys = yString.split(" ");
            int[] xx = {Integer.parseInt(xs[0]),Integer.parseInt(xs[1]),Integer.parseInt(xs[2]),Integer.parseInt(xs[3])};
            int[] yy = {Integer.parseInt(ys[0]),Integer.parseInt(ys[1]),Integer.parseInt(ys[2]),Integer.parseInt(ys[3])};

            String result = isZfx(xx,yy);

            System.out.println(result);

        }

    }

}
