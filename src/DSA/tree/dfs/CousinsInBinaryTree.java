package DSA.tree.dfs;

import DSA.tree.TreeNode;
//https://leetcode.com/problems/cousins-in-binary-tree/
//sometimes in the interview they asked bfs approach
public class CousinsInBinaryTree {
    int xLevel = -1;
    int yLevel = -1;
    TreeNode xParent = null;
    TreeNode yParent = null;
   public static void main(String[] args) {

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,0,null,x,y);

        return xLevel == yLevel && xParent != yParent;
    }
    public void dfs(TreeNode root,int level,TreeNode parent,int x,int y){
        if(root == null) return;

        if(root.val == x){
            xLevel = level;
            xParent = parent;
        }
        if(root.val == y){
            yLevel = level;
            yParent = parent;
        }
        dfs(root.left,level+1,root,x,y);
        dfs(root.right,level+1,root,x,y);
    }
}
