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

}
