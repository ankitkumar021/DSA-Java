package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/subtree-of-another-tree/
//imp
public class SubTreeFromAnotherTree {
   public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(sameTree(root,subRoot)){
            return true;
        }
        return isSubtree(root.left,subRoot) ||
                isSubtree(root.right,subRoot);

    }
    public boolean sameTree(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        return sameTree(root.left,subRoot.left) &&
                sameTree(root.right,subRoot.right);
    }
}
