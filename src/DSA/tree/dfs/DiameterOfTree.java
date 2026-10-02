package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfTree {
    static int dia = 0;
   public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
    public static int height(TreeNode root){
        if(root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);


        dia = Math.max(dia,left+right);

        //when i am at 5 we have add1 for edge it is returned to 2
        return Math.max(left,right)+1;//max can be either from left or right side

    }
}
