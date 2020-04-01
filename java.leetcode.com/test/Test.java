import com.lisy.problems.Solution;

/**
 * Copyright © 贝壳找房（北京）科技有限公司.
 * User: lishaoyao001
 * Date: 2019-03-27
 * Time: 21:52
 * Desc:
 */

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] intArray = {1,1,2,3};
        System.out.println(solution.hasGroupsSizeX(intArray));*/
        int[] params = {5, 0, 3, 6, 8};
        System.out.println(solution.partitionDisjoint(params));
    }
}
