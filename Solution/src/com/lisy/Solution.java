package com.lisy;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by NEUNB_Lisy on 2017/11/11.
 * https://www.nowcoder.com/ta/coding-interviews   在线编程->剑指offer
 */
public class Solution {


    /**
     * 替换空格
     * 时间限制：1秒 空间限制：32768K
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        String result = str.toString();
        return result.replace(" ","%20");
    }
    /**
     * 从尾到头打印链表
     * 时间限制：1秒 空间限制：32768K
     * 输入一个链表，从尾到头打印链表每个节点的值。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (;listNode!=null;){
            temp.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = temp.size()-1;i>=0;i--){
            result.add(temp.get(i));
        }
        return result;
    }
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
    * 重建二叉树
    * 时间限制：1秒 空间限制：32768K
    * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
    */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode result = null;
        if (pre.length == 0){
            return  null;
        }
        int middle =0;
        for(int i =0;i<in.length;i++){
            if (pre[0] == in[i]){
                middle = i;
                break;//跳出for循环
            }
        }
        int[] lpre = new int[middle];
        int[] lin = new int[middle];
        int[] rin = new int[in.length-middle];
        int[] rpre = new int[pre.length-middle];
        for (int i=0;i<middle;i++){
            lin[i] = in[i];
            lpre[i] = pre[1+i];
        }
        int j = 0;
        for (int i = middle+1;i<in.length;i++){
            rin[j] = in[i];
            rpre[j] = pre[i];
            j++;
        }
        result.left = reConstructBinaryTree(lpre,lin);
        result.right = reConstructBinaryTree(rpre,rin);
        return result;
    }
    /*public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }*/

    /**
    * 用两个栈实现队列
    * 时间限制：1秒 空间限制：32768K
    * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
    */
    Stack<Integer> stack1 = new Stack<Integer>();//存储队列 正 顺序
    Stack<Integer> stack2 = new Stack<Integer>();//存储队列 负 顺序
    //向队列中加入元素
    /*public void push(int node) {
        stack1.push(new Integer(node));
    }
    //向队列中取出元素
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop().intValue();
    }*/

    /**
    * 旋转数组的最小数字
    * 时间限制：3秒 空间限制：32768K
    * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int sign = array[0];
        for (int i=1;i<array.length;i++){
            if (sign>array[i]){
                sign=array[i];
                break;
            }
        }
        return sign;
    }

    /**
    * 斐波那契数列
    * 时间限制：1秒 空间限制：32768K
    * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
    */
    public int Fibonacci(int n) {
        if(n>0){
            if (n>2){
                return Fibonacci(n-1)+Fibonacci(n-2);
            }else{
                return 1;
            }
        }else {
            return 0;
        }
    }

    /**
    * 跳台阶
    * 时间限制：1秒 空间限制：32768K
    * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    *
    * 解析
    * 假设，一级台阶，有f(1)种方法，二级有f(2)种，以此类推，n级有f(n)种方法。
    * 可以看出，f(1)=1;f(2)=2。
    * 那么，假设n级台阶，那么第一步就有两种情况，跳一步，跟跳两步。
    * 情况一：跳一步，那么接下去的就是f(n-1)；
    * 情况二：跳两步，那么接下去的就是f(n-2)。
    * 所以总数是f(n)=f(n-1)+f(n-2)。
    *
    */
    public int JumpFloor(int target) {
        if (target<=0){
            return -1;
        }
        if (target == 1|| target==2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    /**
    * 变态跳台阶
    * 时间限制：1秒 空间限制：32768K
    * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    *
    * 解析
    * 假设f(n)是n个台阶跳的次数。
    * f(1) = 1
    * f(2) 会有两个跳得方式，一次1阶或者2阶，这回归到了问题f(1),f(2) = f(2-1) + f(2-2)
    * f(3) 会有三种跳得方式，1阶、2阶、3阶，那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3).因此结论是
    * f(3) = f(3-1)+f(3-2)+f(3-3)
    * f(n)时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
    * f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1) == f(n) = 2*f(n-1)
    */
    public int JumpFloorII(int target) {
        if (target<=0){
            return 0;
        }
        if (target==1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }

    /**
    * 矩形覆盖
    * 时间限制：1秒 空间限制：32768K
    * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    */
    public int RectCover(int target) {
        if (target < 1){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target==2){
            return 2;
        }
        return RectCover(target-1)+RectCover(target-2);
    }

    /**
    * 二进制中1的个数
    * 时间限制：1秒 空间限制：32768K
    * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
    *
    * (1) 利用Java内置toBinaryString方法来实现
    */
    public int NumberOf1(int n) {
        int result = 0;
        String str = Integer.toBinaryString(n);
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)=='1'){
                result++;
            }
        }
        return result;
    }
    /**
     * 利用位运算来实现 思路： 将n与n-1做与运算，会把最右边的1去掉。 比如： 1100 & 1011 = 1000 ，即 12 & 11 = 8
     * 再利用计算器count++计算出有多少个 1 即可。
     */
    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
    * 数值的整数次方
    * 时间限制：1秒 空间限制：32768K
    * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    */
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }

    /**
    * 调整数组顺序使奇数位于偶数前面
    * 时间限制：1秒 空间限制：32768K
    * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
    */
    public void reOrderArray(int [] array) {
        int[] result = new int[array.length];
        int index=0;
        for (int i=0;i<array.length;i++){
            if (array[i]%2 == 1){
                result[index]=array[i];
                index++;
            }
        }
        for (int i=0;i<array.length;i++){
            if (array[i]%2==0){
                result[index]=array[i];
                index++;
            }
        }
        for (int i=0;i<array.length;i++){
            array[i]=result[i];
        }
    }

    /**
    * 链表中倒数第k个结点
    * 时间限制：1秒 空间限制：32768K
    * 输入一个链表，输出该链表中倒数第k个结点。
    */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null){
            return null;
        }
        int length=1;//记录当前链表的长度
        ListNode tem = head;
        while (tem.next!=null){
            length ++;
            tem = tem.next;
        }
        if (k>length){
            return null;
        }
        for(int i=0;i<length;i++){
            if (k+i==length){
                return head;
            }else {
                head=head.next;
            }
        }
        return null;
    }

    /**
    * 合并两个排序的链表
    * 时间限制：1秒 空间限制：32768K
    * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode result = null;
        if (list1.val>list2.val){
            result = list2;
            result.next = Merge(list1,list2.next);
        }else {
            result = list1;
            result.next = Merge(list1.next,list2);
        }
        return result;
    }

    /**
    * 树的子结构
    * 时间限制：1秒 空间限制：32768K
    * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
    */
    public boolean Isroot1hasroot2 (TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }else if(root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return Isroot1hasroot2(root1.left,root2.left) && Isroot1hasroot2(root1.right,root2.right);
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1!=null &&root2!=null){
            if (root1.val == root2.val){
                result = Isroot1hasroot2(root1,root2);
            }
            if (!result)
                result = Isroot1hasroot2(root1.left,root2);
            if (!result)
                result = Isroot1hasroot2(root1.right,root2);
        }
        return result;
    }
    /*public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean tag = false;
        if (root2 == null || root1 == null)
            return tag;
        String root1_preorder = null,root1_inorder = null,root2_preorder = null,root2_inorder = null,root1_postorder=null,root2_postorder=null;
        root1_preorder = Preorder(root1);
        root2_preorder = Preorder(root2);
        root1_inorder = Inorder(root1);
        root2_inorder = Inorder(root2);
        root1_postorder = Postorder(root1);
        root2_postorder = Postorder(root2);
        if (root1_inorder.indexOf(root2_inorder)!=-1 && root1_preorder.indexOf(root2_preorder)!=-1 && root1_postorder.indexOf(root2_postorder)!=-1){
            tag=true;
        }
        return tag;
    }
    //先序遍历二叉树
    public String Preorder(TreeNode root){
        String str = "";
        if (root!=null){
            str += String.valueOf(root.val);;
            Preorder(root.left);
            Preorder(root.right);
        }
        return str;
    }
    //中序遍历二叉树
    public String Inorder(TreeNode root){
        String str="";
        if (root!=null){
            Inorder(root.left);
            str += String.valueOf(root.val);
            Inorder(root.right);
        }
        return str;
    }
    //后序遍历二叉树
    public String Postorder(TreeNode root){
        String str="";
        if (root!=null){
            Postorder(root.left);
            Postorder(root.right);
            str += String.valueOf(root.val);;
        }
        return str;
    }*/

    /**
    * 二叉树的镜像
    * 时间限制：1秒 空间限制：32768K
    * 操作给定的二叉树，将其变换为源二叉树的镜像。
    */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        if (root!=null){
            TreeNode tem = null;
            if (root.left!=null || root.right!=null){
                tem = root.left;
                root.left = root.right;
                root.right=tem;
            }
            if (root.left!=null)
                Mirror(root.left);
            if (root.right!=null)
                Mirror(root.right);
        }
    }

    /**
    * 顺时针打印矩阵
    * 时间限制：1秒 空间限制：32768K
    * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
    */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length>1 && matrix[0].length>1){
            for (int i=0;i<matrix[0].length;i++){
                list.add(matrix[0][i]);
            }
            int[][] tem = new int[matrix[0].length][matrix.length-1];
            for(int i=1;i<matrix.length;i++){
                for (int j=0;j<matrix[0].length;j++){
                    tem[j][i-1] = matrix[i][matrix[0].length-1-j];
                }
            }
            list.addAll(printMatrix(tem));
        }
        if (matrix == null){
            return null;
        }
        if (matrix.length == 1){
            for (int i=0;i<matrix[0].length;i++){
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (matrix[0].length == 1){
            for (int i=0;i<matrix.length;i++){
                list.add(matrix[i][0]);
            }
            return list;
        }
        return list;
    }

    /**
    * 包含min函数的栈
    * 时间限制：1秒 空间限制：32768K
    * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
    */
    Stack stack = new Stack();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        int top = (int) stack.pop();
        return top;
    }

    public int min() {
        Stack stacMin = new Stack();
        int minre = (int) stack.pop();
        stacMin.push(minre);
        while (!stack.isEmpty()){
            int tem = (int) stack.pop();
            stacMin.push(tem);
            if (tem<minre)
                minre=tem;
        }
        while (!stacMin.isEmpty()){
            stack.push(stacMin.pop());
        }
        return minre;
    }

    /**
    * 栈的压入、弹出序列
    * 时间限制：1秒 空间限制：32768K
    * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
    */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length<=0 || popA.length<=0){
            return false;
        }
        int j=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            if (pushA[i]==popA[j]){
                if (j++==popA.length-1){
                    return true;
                }
                stack.pop();
            }
        }
        while (!stack.empty()){
            if(stack.pop()!=popA[j++]){
                return false;
            }
        }
        return true;
    }

    /**
     * 从上往下打印二叉树
     * 时间限制：1秒 空间限制：32768K
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
        if (root==null)
            return arrayList;
        treeList.add(root);
        for (int i=0;i<treeList.size();i++){
            TreeNode node = treeList.get(i);
            if (node.left!=null)
                treeList.add(node.left);
            if (node.right!=null)
                treeList.add(node.right);
            arrayList.add(node.val);
        }
        return arrayList;
    }

    /**
     * 二叉搜索树的后序遍历序列
     * 时间限制：1秒 空间限制：32768K
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        /*if (sequence==null)
            return true;
        int last = sequence[sequence.length-1];
        //将sequence二分，index记录中间的位置
        int index=0;
        for (int i=0;i<sequence.length-1;i++){
            if (i!=sequence.length-1){
                if (last<sequence[i]&&last>sequence[i+1])
                    break;
                if (last>sequence[i]&&last<sequence[i+1])
                    index=i;
            }else if(last==sequence[i+1]){
                index=sequence.length-2;
            }
        }
        boolean tag_l=true,tag_r=true;
        boolean bigtag=true;
        if (index!=0){
            int[] sequence_l = new int[index+1];
            for(int i=0;i<=index;i++){
                sequence_l[i]=sequence[i];
                if (last<sequence[i]) {
                    tag_l=false;
                }
            }
            tag_l=VerifySquenceOfBST(sequence_l);
        }
        if (index!=sequence.length-2&&index!=sequence.length-1){
            int[] sequence_r = new int[sequence.length-index-2];
            for (int i=1;i+index<sequence.length-1;i++){
                sequence_r[i-1]=sequence[index+i];
                if (last>sequence[index+i])
                    tag_r=false;
            }
            tag_r=VerifySquenceOfBST(sequence_r);
        }
        if (tag_l && tag_r)
            return true;
        return false;*/
        if (sequence==null||sequence.length==0)
            return false;
        return gets(sequence,0,sequence.length-1);
    }
    public boolean gets(int[] ints,int start,int end){
        int i=0,j=0;
        if (end-start<=1)
            return true;
        for (i=start;i<end;i++){
            if (ints[end]<ints[i])
                break;
        }
        for (j=i;j<end;j++){
            if (ints[j]<ints[end])
                return false;
        }
        boolean tag_l=true,tag_r=true;
        if (i>0){
            tag_l = gets(ints,start,i-1);
        }
        if (j<ints.length-1)
            tag_r = gets(ints,i,end-1);
        return tag_l&&tag_r;
    }

    /*
    * 二叉树中和为某一值的路径
    * 时间限制：1秒 空间限制：32768K
    * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        return null;
    }

}

