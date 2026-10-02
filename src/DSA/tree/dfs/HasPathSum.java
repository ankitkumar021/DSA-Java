package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/path-sum/
public class HasPathSum {
   public static void main(String[] args) {

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        //when reached leaf check for the node value,and root val matched with targetSum
        //means this is the valid path ,return true.
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left,targetSum-root.val) ||
                hasPathSum(root.right,targetSum-root.val);

    }
}
