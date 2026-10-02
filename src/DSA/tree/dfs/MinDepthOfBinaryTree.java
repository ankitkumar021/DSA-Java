package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class MinDepthOfBinaryTree {
   public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
        return height(root);
    }
    public int height(TreeNode root){
        if(root == null) return 0;

        if(root.left == null){//return the right side if left side is null
            return height(root.right)+1;
        }
        if(root.right == null){//return the left side if right is null
            return height(root.left)+1;
        }

        return Math.min(height(root.left),height(root.right))+1;
        //this failed for skew tree{ true when there is node on the both side}
    }
}
