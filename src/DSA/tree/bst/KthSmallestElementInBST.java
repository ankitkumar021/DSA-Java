package DSA.tree.bst;

import DSA.tree.TreeNode;

import java.util.Stack;

public class KthSmallestElementInBST {
    public static void main(String[] args) {

    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){

            while(root != null){
                st.push(root);//push left child to stack
                root = root.left;//keep going left
            }
            root = st.pop();//pop that ele and dec the k
            k--;
            if(k == 0){//if k reach 0 that is our ele
                return root.val;
            }
            root = root.right;//does this has right child also
        }
        return -1;

    }
}
