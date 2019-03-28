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
        if (deck.length<2)
            return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int tem = deck[0];
        for (int i: map.keySet()) {
            if (map.get(i) != map.get(tem))
                return false;
        }
        return true;
    }

}
