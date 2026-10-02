package DSA.tree.bfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//give this ans in the interview
//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class LevelOrderTraversalUsingBFS {
   public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){

            List<Integer> levelList= new ArrayList<>();
            int len = q.size();

            for(int i=0;i<len;i++){//restrict the level what we have to print

                TreeNode node = q.poll();
                levelList.add(node.val);

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }

            }
            //add the current level list into list of list
            ans.add(levelList);
        }

        return ans;

    }
}
