import com.lisy.Solution;

/*https://www.nowcoder.com/ta/coding-interviews   在线编程->剑指offer*/
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        solution.reConstructBinaryTree(pre,in);*/
        int[] test = {6,-3,-2,7,-15,1,2,2};
        System.out.println(solution.NumberOf1Between1AndN_Solution(13));
    }
}
