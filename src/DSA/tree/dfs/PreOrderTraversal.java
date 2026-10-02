package DSA.tree.dfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
    }
    public static void preorder(TreeNode root){
        if(root == null) return;

        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);

    }
}
