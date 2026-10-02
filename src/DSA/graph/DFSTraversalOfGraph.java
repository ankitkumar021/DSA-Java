package DSA.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversalOfGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(dfs(adj));
    }
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];

        dfs(0,adj,ans,visited);
        return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,
                    ArrayList<Integer> ans,boolean[] visited){

        ans.add(node);//add the node
        visited[node]=true;//mark true

        for(int nei : adj.get(node)){//0 is at index 0{2,3,1} is nei

            if(!visited[nei]){//now keep visiting the child if not visited
                dfs(nei,adj,ans,visited);
            }
        }
    }
}
