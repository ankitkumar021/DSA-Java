package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/same-tree/
public class SameTree {
    public static void main(String[] args) {

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p== null || q==null) return false;
        if(p.val != q.val){
            return false;
        }
        //boolean left = isSameTree(p.left,q.left);
        //boolean right = isSameTree(p.right,q.right);
        //return left && right
        //or below

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }
}
