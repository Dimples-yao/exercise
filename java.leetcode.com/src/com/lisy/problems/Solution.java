/**
 * Copyright © 贝壳找房（北京）科技有限公司.
 * User: lishaoyao001
 * Date: 2019-03-27
 * Time: 21:30
 * Desc:
 */
package com.lisy.problems;

import java.util.*;

public class Solution {

    /**
     * 卡牌分组：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
     * @param deck
     * @return boolean
     */
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int val = -1;
        boolean isFirst = true;
        for(int key:map.keySet()){
            if (isFirst){
                val = map.get(key);
                isFirst = false;
            }else {
                val = GetGCD(val, map.get(key));
            }
            if (val <= 1)
                return false;
        }
        return true;
    }
    private int GetGCD(int a,int b){
        if (a<b){
            int tem = b;
            b = a;
            a = tem;
        }
        return a%b == 0 ? b : GetGCD(b,a%b);
    }

    /**
     * 最大交换：https://leetcode-cn.com/problems/maximum-swap/
     * @param num
     * @return int
     */
    public int maximumSwap(int num) {
        char[] numchars = String.valueOf(num).toCharArray();
        for (int i = 0; i < numchars.length; i++) {
            int[] maxTag = getMaxNum(numchars,i);
            if (maxTag[0] != i && maxTag[1] != Integer.valueOf(numchars[i])){
                char tem = numchars[i];
                numchars[i] = (char) maxTag[1];
                numchars[maxTag[0]] = tem;
                return Integer.valueOf(String.valueOf(numchars));
            }
        }
        return num;
    }
    private int[] getMaxNum(char[] numschar,int i){
        int[] maxTag = new int[2];
        maxTag[0] = i;
        maxTag[1] = numschar[i];
        for (int j = i; j < numschar.length; j++) {
            if (maxTag[1]<=numschar[j]){
                maxTag[1] = Integer.valueOf(numschar[j]);
                maxTag[0] = j;
            }
        }
        return maxTag;
    }

}
