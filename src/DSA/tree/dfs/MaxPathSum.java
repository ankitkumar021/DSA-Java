package DSA.tree.dfs;

import DSA.tree.TreeNode;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;

    }
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        //if left or right is negative ignore it by by replacing it with 0
        //instead of decrese the maxsum ans it will return 0 from that side

        left = Math.max(0,left);
        right = Math.max(0,right);

        int currentPathSum = left+root.val+right;

        maxSum = Math.max(maxSum,currentPathSum);

//root is same+ max path from sides(beacuse what if we have return both and parent is gretaer than either left or right so how do you calculate the path beacuse wont
// be contigious) so any 1 can be returned either left or right side.
        return root.val+Math.max(left,right);
    }
}
