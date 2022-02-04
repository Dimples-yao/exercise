package lisy.written.com.wangyi;

import java.util.Scanner;

public class Third {

    public static void findJobs(int[][] jobList,int[] peoList){

        int[][] peoJobResult = new int[peoList.length][4];

        for (int i=0;i<peoList.length;i++){

            int j = 0;
            if (i>0){
                j = peoJobResult[i-1][3];
            }
            for (;j<jobList.length;j++){
                if (peoList[i]>=jobList[j][0] && peoJobResult[i][2]<=jobList[j][1]){
                    peoJobResult[i][0] = peoList[i];
                    peoJobResult[i][1] = jobList[j][0];
                    peoJobResult[i][2] = jobList[j][1];
                    peoJobResult[i][3] = j;
                }
            }
            System.out.println(peoJobResult[i][2]);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jobs = scanner.nextInt();
        int peoples = scanner.nextInt();

        int[][] jobsList = new int[jobs][2];
        for (int i=0;i<jobs;i++){
            jobsList[i][0] = scanner.nextInt();
            jobsList[i][1] = scanner.nextInt();
        }
        int[] peoList = new int[peoples];
        for (int i=0;i<peoples;i++){
            peoList[i] = scanner.nextInt();
        }
        findJobs(jobsList,peoList);
    }
}
