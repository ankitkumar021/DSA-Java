package DSA.tree.dfs.bst;

import DSA.tree.TreeNode;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        //array is sorted

        return createTree(nums,0,nums.length-1);

    }
    public TreeNode createTree(int[] nums,int start,int end){
        //binary search
        if(start>end) return null;

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(nums[mid]);//root should be mid ele

        root.left = createTree(nums,start,mid-1);
        root.right = createTree(nums,mid+1,end);


        return root;



    }
}
