package DSA.tree.bfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {
   public   static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean flag = true;

        while(!q.isEmpty()){

            LinkedList<Integer> list = new LinkedList<>();
            int level = q.size();

            for(int i=0;i<level;i++){
                TreeNode node = q.poll();
                if(flag){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);//reversed
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            ans.add(list);
            flag=!flag;

        }
        return ans;

    }
}
