package DSA.tree.bfs;

import DSA.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsUsingLevelOrder {
    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean xfound = false;
        boolean yfound = false;

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();

                if (node.val == x) {//pick a node from queue{same level node}
                    xfound = true;
                }
                if (node.val == y) {//pick a node from queue{same level node}
                    yfound = true;
                }
                //if sibling(same parent) return false
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y ||
                            node.right.val == x && node.left.val == y) {
                        return false;
                    }
                }

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }

            if (xfound && yfound) {//they are cousins (different parent) but at same level
                return true;
            }
            if (xfound || yfound) {
                return false;
            }
        }
        return false;

    }
}
