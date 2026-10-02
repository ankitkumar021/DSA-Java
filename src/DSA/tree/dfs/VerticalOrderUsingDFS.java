package DSA.tree.dfs;

import DSA.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

public class VerticalOrderUsingDFS {
    List<int[]>list = new ArrayList<>();
    public static void main(String[] args) {

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root,0,0);
        Collections.sort(list,(a, b)->{
            //we are sorting in ascending order
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();
        //helps to decide whether we have create a new list or insert in the //previous list
        //col->-2->[4]
        //col->-1->[2,6]
        //so at col -2 we have to insert 4 and as we moves to different col we
        //have to create a arraylist and insert 2 and 6

        int prevCol = Integer.MIN_VALUE;
        for(int[] arr:list){
            if(arr[0]!=prevCol){
                //create an arrayList
                ans.add(new ArrayList<>());
                prevCol = arr[0];
            }
            ans.get(ans.size()-1).add(arr[2]);
        }
        return ans;
    }
    public void dfs(TreeNode root,int col,int row){
        if(root == null){
            return;
        }
        list.add(new int[]{col,row,root.val});
        dfs(root.left,col-1,row+1);
        dfs(root.right,col+1,row+1);
    }
}
