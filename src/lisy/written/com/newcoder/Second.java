package lisy.written.com.newcoder;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class Second {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curLevCnt = 1;
        int nextLevCnt = 0;
        ArrayList<Integer> levelres = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            curLevCnt--;
            levelres.add(cur.val);
            if(cur.left != null){
                queue.add(cur.left);
                nextLevCnt++;
            }
            if(cur.right != null){
                queue.add(cur.right);
                nextLevCnt++;
            }
            if(curLevCnt == 0){
                curLevCnt = nextLevCnt;
                nextLevCnt = 0;
                res.add(levelres);
                levelres = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
