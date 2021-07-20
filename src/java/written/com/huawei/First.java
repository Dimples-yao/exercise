package java.written.com.huawei;

import java.util.*;

public class First {
    /*public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        rsort(str);
    }

    public static int[][] countChar(String str){
        //用一个二维数组存放字符和对应的字数
        //用数组的缺点是空间浪费 可以用map 或别的代替这里就用数组简单点
        int arr[][] = new int[2][str.length()];
        for(int i=0;i<str.length();i++){
            boolean isExist = false;//字符是否存在标志
            for(int j=0;j<str.length();j++){
                if(str.charAt(i)==arr[0][j]){
                    arr[1][j]++;
                    isExist = true;
                }
            }
            //全部循环完成后，如果存在，数目加1，存在标志变为true，如果标志还是false则把这个字符加到数组里
            if(!isExist){
                arr[0][i]=str.charAt(i);
                arr[1][i]=1;
            }
        }
        *//*for(int k=0;k<str.length();k++){
            if(arr[0][k]!=0){
                System.out.println("字符"+(char)arr[0][k]+"的数目为"+arr[1][k]);
            }
        }*//*
        return arr;
    }

    public static void quickSort(int a[][],int l,int r){
        if(l>=r)
            return;

        int i = l; int j = r;
        int keytop = a[0][l];//选择第一个数为key
        int keydown = a[1][l];//选择第一个数为key

        while(i<j){

            while(i<j && a[0][j]>=keytop)//从右向左找第一个小于key的值
                j--;
            if(i<j){
                a[0][i] = a[0][j];
                a[1][i] = a[1][j];
                i++;
            }

            while(i<j && a[0][i]<keytop)//从左向右找第一个大于key的值
                i++;

            if(i<j){
                a[0][j] = a[0][i];
                a[1][j] = a[1][i];
                j--;
            }
        }
        //i == j
        a[0][i] = keytop;
        a[1][i] = keydown;
        quickSort(a, l, i-1);//递归调用
        quickSort(a, i+1, r);//递归调用
    }

    public static String rsort(String str){
        int[][] arr = countChar(str);
//        quickSort(arr,0,arr.length-1);
        for(int k=0;k<str.length();k++){
            if(arr[0][k]!=0){
                System.out.println("字符"+(char)arr[0][k]+"的数目为"+arr[1][k]);
            }
        }
        return null;
    }*/

    public static ArrayList<Character> newChar(ArrayList<Character> list){
        if (list.isEmpty())
            return null;
        ArrayList<Character> newList = new ArrayList<>();
        char tem = list.get(0);
        newList.add(tem);
        for (Character a:list){
            if (a!=tem){
                newList.add(a);
                tem = a;
            }
            list.remove(a);
        }
        newChar(list);
        return newList;
    }

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        char[] charts = new char[str.length()];
        for (int i=0;i<str.length();i++){
            charts[i] = str.charAt(i);
        }
        Arrays.sort(charts);
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0;i<charts.length;i++){
            list.add(charts[i]);
        }

        System.out.println(charts);
    }

}
