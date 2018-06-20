package com.jdjr;

import java.util.*;

public class Main {

    List<String> result = new LinkedList<String>();


    // 从字符串s中选择m个字符
    public void perm(String s, int m) {

        // 如果m==0，则递归结束。输出当前结果
        if (m == 0) {
            /*for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();*/
            return ;
        }

        if (s.length() != 0) {
            // 选择当前元素
            result.add(s.charAt(0) + "");
            perm(s.substring(1, s.length()), m - 1);
            result.remove(result.size() - 1);
            // 不选当前元素
            perm(s.substring(1, s.length()), m);
        }
    }

    /**
     * 判断该字符串是不是回文
     * @param str
     */
    public static boolean isHw(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        String newStr=new String(sb);
        if(str.equals(newStr)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 得到所有的回文，并将其个数返回
     * @param str
     */
    public int huiwens(String str){
        Main main = new Main();
        if (str.equals(null))
            return 0;
        for (int i = 1; i <= str.length(); i++) {
            main.perm(str, i);
        }

        List<String> huiwen = new ArrayList<>();
        for (String s:result){
            if (isHw(s))
                huiwen.add(s);
        }
        return huiwen.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Main main = new Main();
        System.out.println(main.huiwens(str));
    }
}
