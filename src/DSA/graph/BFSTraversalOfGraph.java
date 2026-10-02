package DSA.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFSTraversalOfGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(2, 3, 1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(0, 4)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(bfs(adj));//[0, 2, 3, 1, 4]

    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        //size of visited array is equal to adj list
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();

        q.offer(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int nei : adj.get(node)) {//go to the neighbour of cur node
                if (!visited[nei]) {
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }
        return ans;
    }

}

