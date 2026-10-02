package DSA.tree.dfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);

    }
}
