package written.com.wangyi;

import java.util.Scanner;

public class Third_1 {

    public static void findJobs(int[][] jobList,int[] peoList){
        for (int i=0;i<peoList.length;i++){
            int tem = 0;

            for (int j=0;j<jobList.length;j++){
                if (peoList[i]>=jobList[j][0] ){
                    if (tem<=jobList[j][1])
                        tem=jobList[j][1];
                }
            }
            System.out.println(tem);
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
