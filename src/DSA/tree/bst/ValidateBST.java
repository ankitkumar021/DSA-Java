package DSA.tree.bst;

import DSA.tree.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
    public boolean dfs(TreeNode root,long min,long max){
        if(root == null) return true;

        if(root.val <=min || root.val >=max) return false;//negative case

        //check if left is < root{here max value is root.val} and right is > root
        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
    }
}
