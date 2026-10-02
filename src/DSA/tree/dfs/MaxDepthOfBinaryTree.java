package DSA.tree.dfs;

import DSA.tree.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return height(root);

    }

    public int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
}
