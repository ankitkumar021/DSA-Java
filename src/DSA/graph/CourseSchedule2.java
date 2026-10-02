package DSA.graph;

import java.util.*;

public class CourseSchedule2 {
    public static void main(String[] args) {
       int[][] prerequisites = {
               {1,0},
               {2,0},
               {3,1},
               {3,2}
       };
       int numCourses = 4;
        System.out.println(Arrays.toString(findOrder(numCourses,prerequisites)));//[0, 1, 2, 3]

    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre :prerequisites){//populate the graph
            adj.get(pre[1]).add(pre[0]);

        }

        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){//populate the indegree
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] topOrder = new int[numCourses];
        int visited = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topOrder[visited++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return visited == numCourses ? topOrder : new int[0];
    }
}
