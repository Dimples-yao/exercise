package java.newcoder.com;

import java.util.*;

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
        ListNode() {};
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

    /**
     * 反转链表
     * 时间限制：1秒 空间限制：32768K 热度指数：195876
     * 输入一个链表，反转链表后，输出链表的所有元素。
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pPre= null;
        ListNode pNext= null;
        while (head != null){
            pNext = head.next;
            head.next = pPre;
            pPre = head;
            head = pNext;
        }
        return pPre;
    }

    /*
    * 二叉树中和为某一值的路径
    * 时间限制：1秒 空间限制：32768K
    * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
    */
    // 存放所有路径
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    // 用于遍历
    ArrayList<Integer> list = new ArrayList<Integer>();
    int num = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null)
            return lists;
        num+=root.val;
        list.add(root.val);
        if (num == target && root.right==null && root.left==null){
            ArrayList<Integer> path = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                path.add(list.get(i));
            }
            lists.add(path);
        }

        if (num<target && root.left!=null){
            FindPath(root.left,target);
        }

        if (num<target && root.right!=null){
            FindPath(root.right,target);
        }

        num-=root.val;

        list.remove(list.size()-1);

        return lists;
    }

    /**
     * 时间限制：1秒 空间限制：32768K 热度指数：176974
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    RandomListNode temp;
    RandomListNode result = temp;
    public RandomListNode Clone(RandomListNode pHead) {
        temp = pHead;
        if (pHead.next!=null){
            temp = temp.next;
            Clone(pHead.next);
        }
        if (pHead.random!=null){
            temp = temp.random;
            Clone(pHead.random);
        }
        return result;
    }

    /**
     * 二叉搜索树与双向链表
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {

        /*首先判断该节点是否为空, 为空则直接返回*/
        if (pRootOfTree==null)
            return null;

        /*判断根节点的左右节点是否为空, 若都为空, 则直接返回根节点*/
        if (pRootOfTree.left==null&&pRootOfTree.right==null)
            return pRootOfTree;

        /*将根节点的左子树遍历为双向链表*/
        TreeNode left = Convert(pRootOfTree.left);

        /*定义一个临时节点, 用于遍历左子树到尾节点*/
        TreeNode p = left;
        while (p!=null&&p.right!=null){
            p = p.right;
        }
        /*如果左子树不为空, 则将左子树遍历后成双向队列的尾节点指向根节点*/
        if (left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        /*将右子树转换为有序双向队列*/
        TreeNode right = Convert(pRootOfTree.right);
        /*如果右子树不为空, 则将左子树的最后一个节点指向右子树的头节点*/
        if (right!=null){
            right.left=pRootOfTree;
            pRootOfTree.right = right;
        }

        return left!=null?left:pRootOfTree;
    }

    /**
     * 字符串的排列
     * 时间限制：1秒 空间限制：32768K 热度指数：207351
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 输入描述:
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> resultPermutation = new ArrayList<>();
        if (str.equals("")||str.length()==0)
            return resultPermutation;
        TreeSet<String> treeSet = new TreeSet<>();
        char[] chars = str.toCharArray();
        changeChars(chars,0,chars.length-1,treeSet);
        resultPermutation.addAll(treeSet);
        return resultPermutation;
    }
    public void changeChars(char[] chars,int star, int end, TreeSet<String> treeSet){
        if (star==end)
            treeSet.add(String.valueOf(chars));
        else {
            for (int i = star;i<=end;i++){
                swap(chars,star,i);
                changeChars(chars,star+1,end,treeSet);
                swap(chars,star,i);
            }
        }
    }
    public void swap(char[] chars,int star, int end){
        if (star==end){}else {
            char tem = chars[star];
            chars[star] = chars[end];
            chars[end] = tem;
        }
    }

    /**
     * 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:array){
            if (map.containsKey(x)){
                int i = map.get(x)+1;
                map.put(x,i);
            }else {
                map.put(x,1);
            }
        }
        for (int x:map.keySet()){
            if (map.get(x)>(array.length/2))
                return x;
        }
        return 0;
    }

    /**
     * 最小的K个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (k>input.length){
            return result;
        }
        for (int i:input)
            set.add(i);
        int tem=0;
        for (int i:set){
            if (tem<k){
                result.add(i);
                tem++;
            }
        }
        return result;
    }

    /**
     * 连续子数组的最大和
     * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum =0;
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(sum>=0)
            {  //首先进行求和
                sum= sum+array[i];
            }else{
                //求和的正数区间结束，将当前的值设置为初值
                sum=array[i];
            }
            if(sum>max)
                //记录每个求和区间的最大值
                max = sum;
        }
        return max;
    }

    /**
     * 整数中1出现的次数（从1到n整数中1出现的次数）
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int result = 0;
        for (int i=0;i<=n;i++){
            String str = String.valueOf(i);
            char[] chars = str.toCharArray();
            for (char a:chars){
                if (String.valueOf(a).equals("1")){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length==0)
            return "";
        String[] strs = new String[numbers.length];
        for (int i=0;i<numbers.length;i++)
            strs[i] = String.valueOf(numbers[i]);
        TreeSet<Long> set = new TreeSet<>();
        changeStrings(0,numbers.length-1,strs,set);
        return String.valueOf(set.first());
    }
    public void changeStrings(int start,int end,String[] strings,TreeSet<Long> set){
        if (start==end){
            StringBuilder tem = new StringBuilder();
            for (String str:strings){
                tem.append(str);
            }
            set.add(Long.valueOf(String.valueOf(tem)));
        }else {
            for (int i = start;i<=end;i++){
                swapString(strings,start,i);
                changeStrings(start+1,end,strings,set);
                swapString(strings,start,i);
            }
        }
    }
    public void swapString(String[] strings,int start,int end){
        if (start==end){}else {
            String tem;
            tem = strings[start];
            strings[start] = strings[end];
            strings[end] = tem;
        }
    }

    /**
     * 丑数
     * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    /*该方法时间复杂度太大
    public int GetUglyNumber_Solution(int index) {
        int count = 0;
        int i;
        for(i=1;count<=index;i++){
            if(judgeUglyNumber(i))
                count++;
        }
        return i;
    }
    public boolean judgeUglyNumber(int n){
        while(n%3==0)
            n = n/3;
        while(n%2==0)
            n = n/2;
        while(n%5==0)
            n = n/5;
        if(n==1)
            return true;
        else
            return false;
    }*/
    public int GetUglyNumber_Solution(int index) {
        if (index==0)
            return 0;
        int[] a = new int[index];
        int count = 1;
        a[0] = 1;
        int index2=0;
        int index3=0;
        int index5=0;
        while (count<index){
            a[count] = getMinUgly(a[index2]*2,a[index3]*3,a[index5]*5);
            while (a[index2]*2<=a[count]) index2++;
            while (a[index3]*3<=a[count]) index3++;
            while (a[index5]*5<=a[count]) index5++;
            count++;
        }
        return a[index-1];
    }
    public int getMinUgly(int a,int b, int c){
        int tem = a>b?b:a;
        return c>tem?tem:c;
    }

    /**
     * 第一个只出现一次的字符
     * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
     * 未完成
     */
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer[]> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if (map.containsKey(chars[i])){
                Integer[] tem = map.get(chars[i]);
                tem[1] = tem[1]+1;
            }else {
                Integer[] tag = new Integer[2];
                tag[0] = i;
                tag[1] = 1;
                map.put(chars[i], tag);
            }
        }

        for (Character c:map.keySet()){
            Integer[] tag_tem = map.get(c);
            if (tag_tem[1]==1){
                return tag_tem[0];
            }
        }
        return -1;
    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     * 数据范围：
     * 	对于%50的数据,size<=10^4
     * 	对于%75的数据,size<=10^5
     * 	对于%100的数据,size<=2*10^5
     *
     * 示例1
     * 输入
     * 1,2,3,4,5,6,7,0
     * 输出
     * 7
     */
    public int InversePairs(int[] array) {
        if (array.length==0 || array.length==1)
            return 0;
        int[] temp = new int[array.length];
        return inversePairsCore(array,temp,0,array.length-1)%1000000007;
    }
    // 使用分类归并算法
    public int inversePairsCore(int array[], int temp[], int start, int end) {
        if (start == end) {
// 递归遍历到只有一个元素
            temp[start] = array[start];
            return 0;
        }
// 中间位置
        int len = (end - start) / 2;
// 左半边逆序对数
        int left_count = inversePairsCore(array, temp, start, start + len) % 1000000007;
// 右半边逆序对数
        int right_count = inversePairsCore(array, temp, start + len + 1, end) % 1000000007;
// 归并排序
        int i = start + len;//记录左边数组的最后一个数的下标
        int j = end;//记录右边数组的最后一个数的下标
        int index = end;//记录复制数组的当前位置
        int count = 0;// 统计逆序数
        while (i >= start && j >= start + len + 1) {
            if (array[i] > array[j]) {
                temp[index] = array[i];
                i--;
                index--;
                count += j - (start + len);
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            } else {
                temp[index] = array[j];
                j--;
                index--;
            }
        }
        //剩下的操作只是让数组排列好顺序
// 处理剩下的左半分支
        for (; i >= start; i--) {
// 右半边已经归并
            temp[index] = array[i];
            index--;
        }
// 处理剩下的右半分支
        for (; j >= start + len + 1; j--) {
// 左半边已经归并
            temp[index] = array[j];
            index--;
        }
        for (int k = start; k <= end; k++) {
            //将原数组进行排序
            array[k] = temp[k];
        }


        return (count + left_count + right_count )% 1000000007;
    }

    /*
    *
    * 两个链表的第一个公共结点
    * 题目描述
    * 输入两个链表，找出它们的第一个公共结点。
    */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListNodeLength(pHead1);
        int length2 = getListNodeLength(pHead2);
        if (length1 == 0 || length2 == 0) {
            return null;
        }

        ListNode pointLongListNode = null;
        ListNode pointShortListNode = null;
        int dif = 0;
        if (length1 > length2) {
            pointLongListNode = pHead1;
            pointShortListNode = pHead2;

        } else {
            pointLongListNode = pHead2;
            pointShortListNode = pHead1;
        }
        dif = Math.abs(length1 - length2);

        for (int i = 0; i < dif; i++) {
            pointLongListNode = pointLongListNode.next;
        }
        while (pointLongListNode != null && pointShortListNode != null
                && pointLongListNode != pointShortListNode) {
            pointLongListNode = pointLongListNode.next;
            pointShortListNode = pointShortListNode.next;
        }

        return pointLongListNode;
    }
    public int getListNodeLength(ListNode listNode){
        if (listNode == null)
            return 0;
        ListNode temp = listNode;
        int i = 0;
        while (temp.next!=null){
            i++;
            temp = temp.next;
        }
        return i;
    }

    /*
    * 数字在排序数组中出现的次数
    * 题目描述
    * 统计一个数字在排序数组中出现的次数。
    */
    public int GetNumberOfK(int [] array , int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x:array) {
            if (map.containsKey(x))
                map.put(x,map.get(x)+1);
            else map.put(x,1);
        }
        if (map.containsKey(k))
            return map.get(k);
        return 0;
    }

    /**
     * 二叉树的深度
     * 题目描述
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left>right?left+1:right+1;
    }

    /**
     * 平衡二叉树
     * 题目描述
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null||(root.left==null&&root.right==null))
            return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left-right)>1)
            return false;
        boolean leftBoolean = IsBalanced_Solution(root.left);
        boolean rightBoolean = IsBalanced_Solution(root.right);
        return leftBoolean&&rightBoolean;
    }

    /**
     * 数组中只出现一次的数字
     * 题目描述
     * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
     */
    //num1,num2分别为长度为1的数组。传出参数
    // 将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean isFirst = true;
        for (int x:array) {
            if (!map.containsKey(x))
                map.put(x,1);
            else map.put(x,map.get(x)+1);
        }
        for (int x:map.keySet()) {
            if (map.get(x)==1){
                if (isFirst){
                    num1[0] = x;
                    isFirst = false;
                }else num2[0] = x;
            }
        }
    }

    /**
     * 和为S的连续正数序列
     * 题目描述
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     * 输出描述:
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        int result = 0;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum==0)
            return lists;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=sum;i++){
            if (result==sum){
                lists.add(list);
                result=0;
                i=list.get(0);
                list = new ArrayList<>();
                continue;
            }
            if (result>sum){
                result=0;
                i=list.get(0);
                list=new ArrayList<>();
                continue;
            }
            list.add(i);
            result+=i;
        }
        return lists;
    }

    /**
     * 和为S的两个数字
     * 题目描述
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 输出描述:
     * 对应每个测试案例，输出两个数，小的先输出。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap<>();
        getAllInteger(array,sum,0,array.length-1,treeMap);
        if (treeMap.size()>0)
            return treeMap.get(treeMap.firstKey());
        return new ArrayList<>();
    }
    public void getAllInteger(int[] array,int sum,int i,int j,TreeMap<Integer,ArrayList<Integer>> treeMap){
        if (i>=j)
            return;
        if (array[i]+array[j]==sum){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(array[i]);
            list.add(array[j]);
            treeMap.put(i*j,list);
            getAllInteger(array,sum,i+1,j,treeMap);
            getAllInteger(array,sum,i,j-1,treeMap);
        }else {
            getAllInteger(array,sum,i+1,j,treeMap);
            getAllInteger(array,sum,i,j-1,treeMap);
        }
    }

    /**
     * 左旋转字符串
     * 题目描述
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
    public String LeftRotateString(String str,int n) {
        if (str.length()==0)
            return "";
        char[] result = new char[str.length()];
        for (int i=n;i<str.length();i++)
            result[i-n] = str.charAt(i);
        for (int i=0;i<n;i++)
            result[i+str.length()-n] = str.charAt(i);
        return String.valueOf(result);
    }

    /**
     * 翻转单词顺序列
     * 题目描述
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] a = str.split(" ");
        StringBuffer o = new StringBuffer();
        int i;
        for (i = a.length; i >0;i--){
            o.append(a[i-1]);
            if(i > 1){
                o.append(" ");
            }
        }
        return o.toString();
    }

    /**
     * 扑克牌顺子
     * 题目描述
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers.length==0)
            return false;
        int kingsNum = 0;
        TreeSet<Integer> nums = new TreeSet<>();
        for (int i:numbers){
            if (i!=0)
                nums.add(i);
            else kingsNum++;
        }
        if (nums.size()+kingsNum!=numbers.length)
            return false;
        int[] numbersTree = new int[nums.size()];
        if (nums.size()==1)
            return true;
        int x=0;
        for (int j:nums) {
            numbersTree[x] = j;
            x++;
        }
        for (int i=0;i<nums.size();i++){
            if (i+1<nums.size()){
                if (numbersTree[i+1]-numbersTree[i]-1<=kingsNum)
                    kingsNum-=(numbersTree[i+1]-numbersTree[i]-1);
                else
                    return false;
            }
        }
        return true;
    }

    /**
     * 孩子们的游戏(圆圈中最后剩下的数)
     * 题目描述
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n==0)
            return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++)
            list.add(i);
        int tag = 0;
        while (list.size()>1){
            for (int i = 0; i < m-1; i++) {
                if (tag<list.size()-1)
                    tag++;
                else tag=0;
            }
            list.remove(tag);
            if (tag==list.size())
                tag=0;
        }
        return list.get(0);
    }

    /**
     * 求1+2+3+...+n
     * 题目描述
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int Sum_Solution(int n) {
        int ans =n;
        boolean t = ((ans!=0) && ((ans += Sum_Solution(n - 1))!=0));
        return ans;
    }

    /**
     * 不用加减乘除做加法
     * 题目描述
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public int Add(int num1,int num2) {
        ArrayList<Integer> listUp = new ArrayList<>();
        ArrayList<Integer> listDown = new ArrayList<>();
        if(num1<0){
            for (int i = 0; i < -num1; i++) {
                listDown.add(i);
            }
        }else{
            for (int i = 0; i < num1; i++) {
                listUp.add(i);
            }
        }
        if (num2>0){
            for (int i = 0; i < num2; i++) {
                listUp.add(i);
            }
        }else {
            for (int i = 0; i < -num2; i++) {
                listDown.add(i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (listDown.size()>listUp.size()){
            for (int i=listUp.size();i<listDown.size();i++){
                list.add(listDown.get(i));
            }
            return -list.size();
        }
        if (listUp.size()>listDown.size()){
            for (int i = listDown.size();i<listUp.size();i++){
                list.add(listUp.get(i));
            }
            return list.size();
        }
        return 0;
    }

    /**
     * 把字符串转换成整数
     * 题目描述
     * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     * 输入描述:
     * 输入一个字符串,包括数字字母符号,可以为空
     * 输出描述:
     * 如果是合法的数值表达则返回该数字，否则返回0
     * 示例1
     * 输入
     * +2147483647
     *     1a33
     * 输出
     * 2147483647
     *     0
     */
    public int StrToInt(String str) {
        if (str.length()==0)
            return 0;
        int result = 0;
        int index = 0;
        boolean out = false;
        if (str.charAt(index)=='+')
            index++;
        else if (str.charAt(index)=='-'){
            out = true;
            index++;
        }
        for (;  index< str.length(); index++) {
            if (str.charAt(index)>='0'&&str.charAt(index)<='9'){
                result = result*10;
                result+=str.charAt(index)-'0';
            }else return 0;
        }
        if (!out)
            return result;
        return -result;
    }

    /**
     * 数组中重复的数字
     * 题目描述
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length==0){
            duplication[0]=-1;
            return false;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:numbers) {
            if (hashSet.contains(i)){
                duplication[0] = i;
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }

    /**
     * 构建乘积数组
     * 题目描述
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i=0;i<A.length;i++){
            int sumExitI = 1;
            for (int j=0;j<A.length;j++){
                if (i!=j){
                    sumExitI = sumExitI*A[j];
                }
            }
            B[i] = sumExitI;
        }
        return B;
    }

    /**
     * 正则表达式匹配
     * 题目描述
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    public boolean match(char[] str, char[] pattern){
        int i = 0;
        int j = 0;
        boolean tag = true;
        while (i<str.length && j<pattern.length){
            if (str[i] == pattern[j]){
                i++;j++;
            }else if (pattern[j]=='.'){
                i++;j++;
            }else {
                char tem = pattern[j];
                int x = 0;
                for (;x+j<pattern.length;x++){
                    if (tem != pattern[x+j])
                        break;
                }
                if (pattern[x+j]!='*'){
                    tag = false;
                    return tag;
                }
                j = x+j+1;
            }
        }

        while (j<pattern.length){
            if (pattern[j]=='.'){
                i++;j++;
            }else {
                char tem = pattern[j]=='*'? ' ':pattern[j];
                int x = 0;
                for (;x+j<pattern.length;x++){
                    if (tem != pattern[x+j])
                        break;
                }
                if (pattern[x+j]!='*'){
                    tag = false;
                    return tag;
                }
                j = x+j+1;
            }
        }

        if (i!=str.length||j!=pattern.length)
            tag = false;
        return tag;
    }

}

