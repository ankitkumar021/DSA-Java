package DSA.tree.dfs;


import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class leftViewOfBinaryTree {
   public static void main(String[] args) {

    }
    public ArrayList<Integer> leftView(TreeNode root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){

            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode node = q.poll();
                if(i == 0){//if it is the 1st node in the level print it.
                    ans.add(node.val);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}
