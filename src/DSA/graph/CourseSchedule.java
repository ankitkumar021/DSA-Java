package DSA.graph;
//https://leetcode.com/problems/course-schedule/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
       int numCourses = 2;
       int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(numCourses,prerequisites));//true
    }
//idea
//first populate the graph
//populate the indegree
//add to queue whose indegree is 0
//keeping and degree the indegree and if it 0 remove the queue
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        //populate the graph
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        //populate the indegree
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        //intially add the node whose indegree is 0
        //we know that while building the indegree there is atleast 1 node
        //whose indegree is 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        //this has topological order
        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            //now remove from indegree also
            for(int it: adj.get(node)){
                indegree[it]--;//decrease the indegree
                if(indegree[it] == 0){//if 0 add to the queue
                    q.offer(it);
                }
            }
        }
        if(topo.size() == numCourses){
            return true;
        }
        return false;
    }
}
