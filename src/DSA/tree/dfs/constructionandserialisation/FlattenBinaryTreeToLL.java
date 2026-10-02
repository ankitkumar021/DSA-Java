package DSA.tree.dfs.constructionandserialisation;

import DSA.tree.TreeNode;

public class FlattenBinaryTreeToLL {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){

            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = null;
            TreeNode rightmost = findRightMost(cur);//check for 4
            rightmost.right = temp;//4 ka right 5 and 6
            cur = cur.right;
        }
    }
    public TreeNode findRightMost(TreeNode root){
        TreeNode cur = root;
        while(cur.right!=null){
            cur = cur.right;
        }
        return cur;
    }
}
