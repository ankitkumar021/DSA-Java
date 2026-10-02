package DSA.tree.dfs;

import DSA.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightViewOfBinaryTree {
  public  static void main(String[] args) {


  }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){

            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode node = q.poll();
                if(i == level-1){//if we are going level and if last node add it.
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
