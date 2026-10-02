package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
   public static void main(String[] args) {

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode leftNode,TreeNode rightNode){
        if(leftNode== null && rightNode==null)return true;
        if(leftNode==null || rightNode==null) return false;//this case is 1 is null,other!=0
        if(leftNode.val != rightNode.val) return false;

        return helper(leftNode.left,rightNode.right) && helper(leftNode.right,rightNode.left);
    }
}
