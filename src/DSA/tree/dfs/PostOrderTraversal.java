package DSA.tree.dfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return ans;
    }
    public void postorder(TreeNode root){
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        ans.add(root.val);

    }
}
