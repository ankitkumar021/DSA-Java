package DSA.tree.lca;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LcaOfBinaryTree {
    static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q){
            return root;//return that node
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;//return left and right parent
        }

        // if(left != null){
        //     return left;//right side is null
        // }
        // if(right !=null){
        //     return right;//left side is null
        // }

        return left!=null?left:right;

    }
}
