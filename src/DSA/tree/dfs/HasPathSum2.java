package DSA.tree.dfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/path-sum-ii/
public class HasPathSum2 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> ansPaths = new ArrayList<>();

        dfsPath(root,targetSum,path,ansPaths);
        return ansPaths;

    }
    public void dfsPath(TreeNode root,int targetSum,List<Integer> path,           List<List<Integer>> ansPaths){

        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            ansPaths.add(new ArrayList<>(path));
        }
        dfsPath(root.left,targetSum-root.val,path,ansPaths);
        dfsPath(root.right,targetSum-root.val,path,ansPaths);

        path.remove(path.size()-1);//clear the list to reuse it.
    }
}
