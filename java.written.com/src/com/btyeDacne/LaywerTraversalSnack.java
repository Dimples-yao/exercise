package com.btyeDacne;

import java.util.LinkedList;

/**
 * @author Lisy
 * @version 1.0
 * @Description 一个二叉树蛇形遍历
 * @Date 2018/7/20
 */
public class LaywerTraversalSnack {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void getSnack(TreeNode root){
        if (root==null)
            return;
        boolean tag = true;
        TreeNode treeNode;
        // 双向队列，当作栈来使用，记录当前层待处理结点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //存储下一层节点
        LinkedList<TreeNode> nextStack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            treeNode = stack.removeLast();
            System.out.println(treeNode.val);
            if (tag){
                if (treeNode.right!=null)
                    nextStack.add(treeNode.right);
                if (treeNode.left!=null)
                    nextStack.add(treeNode.left);
            }else {
                if (treeNode.left!=null)
                    nextStack.add(treeNode.left);
                if (treeNode.right!=null)
                    nextStack.add(treeNode.right);
            }
            //判断当前层是否输出完毕
            if (stack.isEmpty()){
                stack = nextStack;
                nextStack = new LinkedList<>();
                tag=!tag;
            }
        }
    }
}
