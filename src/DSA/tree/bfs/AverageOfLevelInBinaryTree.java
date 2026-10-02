package DSA.tree.bfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelInBinaryTree {
   public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            double avg = 0.0;
            int level = q.size();

            for(int i=0;i<level;i++){

                TreeNode node = q.poll();
                avg +=node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }

            }
            avg = avg/level;
            ans.add(avg);
        }
        return ans;

    }
}
