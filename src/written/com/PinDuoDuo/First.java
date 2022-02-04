package written.com.PinDuoDuo;

import java.util.Scanner;

public class First {
    static String[] names = {"Alice","Bob","Cathy","Dave"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(names[getName(num)]);
    }

    public static int getName(int num){
        if (num==0)
            return -1;
        int result = num;
        int turn = 0;
        while (result>(names.length*Math.pow(2,turn))){
            result = (int) (result-names.length*Math.pow(2,turn));
            turn++;
        }
        if (Math.floor(result/Math.pow(2,turn))==0)
            return 0;
        if (Math.floor(result/Math.pow(2,turn))==1&&result%Math.pow(2,turn)==0)
            return 0;
        else if (Math.floor(result/Math.pow(2,turn))==1&&result%Math.pow(2,turn)!=0)
            return 1;
        if (Math.floor(result/Math.pow(2,turn))==2&&result%Math.pow(2,turn)==0)
            return 1;
        else if (Math.floor(result/Math.pow(2,turn))==2&&result%Math.pow(2,turn)!=0)
            return 2;
        if (Math.floor(result/Math.pow(2,turn))==3&&result%Math.pow(2,turn-1)==0)
            return 2;
        return 3;
    }

    /*public static String getName(int num){
        if (num==0)
            return null;
        Queue<String> queue = new LinkedList<>();
        for (int i=0;i<names.length;i++)
            queue.add(names[i]);
        String result=null;
        while (num!=0){
            result=queue.poll();
            queue.add(result);
            queue.add(result);
            num--;
        }
        return result;
    }*/

}