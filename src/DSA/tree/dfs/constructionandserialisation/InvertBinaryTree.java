package DSA.tree.dfs.constructionandserialisation;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        //swap
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //call left and right
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
