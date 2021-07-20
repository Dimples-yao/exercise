package java.leetcode.com.hashSetSolution;

import java.util.HashSet;

/**
 * @author Lisy
 * @version 1.0
 * @Description
 * @Date 2018/7/9
 */
public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()==nums.length)
            return false;
        return true;
    }

    public static int singleNumber(int[] nums) {
        int x=0;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i=0;i<nums.length;i++){
            if (!hashSet.contains(nums[i]))
                x = nums[i];
            hashSet.add(nums[i]);
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
