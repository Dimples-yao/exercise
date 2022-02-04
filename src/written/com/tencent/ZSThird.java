package written.com.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class ZSThird {

    /**
     * 首先对机器和任务按照工作时长和任务时长进行排序，然后让任务一个个匹配机器，当当前机器符合后，即让下一个任务去继续向下匹配机器
     */
    public static void getReuslt(int mechines,int jobs,int[][] mechineArray,int[][] jobArray){
        int fineshes = 0;
        int sum = 0;
        Arrays.sort(mechineArray);
        Arrays.sort(jobArray);
        int j=mechineArray.length;
        for (int i=jobArray.length-1;i>=0;i--){
            for (;j>=0;){
                if (jobArray[i][1]<mechineArray[j][1]&&jobArray[i][0]<mechineArray[j][0]){
                    fineshes++;
                    sum += (200*jobArray[i][0]+3*jobArray[i][1]);
                    break;
                }else{
                    j--;
                }
            }
        }
        System.out.println(fineshes);
        System.out.println(sum);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int mechines = scanner.nextInt();
        int jobs = scanner.nextInt();
        int[][] mechineArray = new int[mechines][2];
        int[][] jobArray = new int[jobs][2];
        for (int i=0;i<mechines;i++){
            mechineArray[i][0] = scanner.nextInt();
            mechineArray[i][1] = scanner.nextInt();
        }
        for (int i=0;i<jobs;i++){
            jobArray[i][0] = scanner.nextInt();
            jobArray[i][1] = scanner.nextInt();
        }
    }
}
