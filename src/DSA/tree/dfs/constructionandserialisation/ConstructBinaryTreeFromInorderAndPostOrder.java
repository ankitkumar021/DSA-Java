package DSA.tree.dfs.constructionandserialisation;

import DSA.tree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    HashMap<Integer,Integer> map = new HashMap<>();
    int preorderIndex = 0;
    public static void main(String[] args) {

    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        //inorder list is used to find the index

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder,int start,int end){
        if(start>end) return null;//base case

        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        int inorderIndex = map.get(root.val);
        root.left = build(preorder,start,inorderIndex-1);
        root.right = build(preorder,inorderIndex+1,end);

        return root;
    }
}
