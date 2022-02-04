package written.com.zhangyuan;

import java.util.ArrayList;
import java.util.Arrays;

public class First {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length < 1)
            return res;
        Arrays.sort(nums);//对数组元素进行从小到大排序
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(list, nums);
        return res;
    }
    private void solve(ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                solve(list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
    public static void main(String[] args){
        First test = new First();
        int[] num = {1,2,3};
        System.out.println(test.permute(num));
    }
}
