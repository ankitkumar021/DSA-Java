package DSA.tree.dfs;
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class populatingNextRightPointer {
   public static void main(String[] args) {

    }
    //the commented code is correct and most optimise
//    public Node connect(Node root) {
//        if(root == null) return null;
//        dfs(root);
//        return root;
//    }
//    public void dfs(Node node){
//        if(node == null || node.left == null) return;
//
//        if(node!=null && node.left!=null){
//            node.left.next = node.right;
//        }
//        if(node!=null && node.next!=null){//for 5,6
//            node.right.next = node.next.left;
//        }
//        dfs(node.left);
//        dfs(node.right);
//
//    }
}
