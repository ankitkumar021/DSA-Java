package DSA.tree.bfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversalUsingDfs {
   public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        DfsHelper(root,0,ans);
        return ans;

    }
    public void DfsHelper(TreeNode root,int level, List<List<Integer>> ans){
        if(root == null) return;

        if(level == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);
        DfsHelper(root.left,level+1,ans);
        DfsHelper(root.right,level+1,ans);
    }
}
