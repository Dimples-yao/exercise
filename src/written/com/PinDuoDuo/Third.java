package written.com.PinDuoDuo;

import java.util.ArrayList;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        /*while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
            scanner.next();
        }*/
        String[] nums = scanner.nextLine().split(" ");
        scanner.close();
        for (String str:nums)
            list.add(Integer.valueOf(str));
        quickSort(list,0,list.size()-1);
        int carNums = 0;
        //计算出一共有多少个刚好等于一百的数,此时的oneHundred是非一百之后的第一个数
        int oneHundred = 0;
        for (;oneHundred < list.size();oneHundred++) {
            if (list.get(oneHundred)>100)
                break;
        }
        //计算一百沉的一共需要多少辆车, 向下取整
        carNums = (int) Math.floor(oneHundred/3);
        if (oneHundred%3==2)
            carNums++;
        else if(oneHundred%3==1)
            oneHundred--;

        //计算出一共有多少个200沉的货物,此时的twoHundred是非200之后的第一个数
        int twoHundred = list.size()-1;
        for (; twoHundred > 0 ; twoHundred--) {
            if (list.get(twoHundred)<200)
                break;
        }
        //计算二百沉的货物共需要多少辆车
        carNums += list.size()-1-twoHundred;

        int l=oneHundred;
        int r=twoHundred;

        while (l<r){
            if (list.get(l)+list.get(r)<300){
                carNums++;
                l++;
                r--;
            }else {
                carNums++;
                r--;
            }
        }
        if (r==l)
            carNums++;

        System.out.println(carNums);

    }

    /**
     * 快排
     */
    public static void quickSort(ArrayList<Integer> list,int l,int r){
        if(l>=r)
            return;

        int i = l; int j = r; int key = list.get(l);//选择第一个数为key

        while(i<j){

            while(i<j && list.get(j)>=key)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                list.set(i,list.get(j));
                i++;
            }

            while(i<j && list.get(i)<key)//从左向右找第一个大于key的值
                i++;

            if(i<j){
                list.set(j,list.get(i));
                j--;
            }
        }
        //i == j
        list.set(i,key);
        quickSort(list, l, i-1);//递归调用
        quickSort(list, i+1, r);//递归调用
    }

}
