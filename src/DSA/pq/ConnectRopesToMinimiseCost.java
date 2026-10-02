package DSA.pq;

import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/dsa/connect-n-ropes-minimum-cost/
//*
public class ConnectRopesToMinimiseCost {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minCost(arr));
    }

    private static int minCost(int[] arr) {
        //cost is min when i take 2 min ropes at point
        //take min heap and put all the ele is first

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.offer(n);
        }
        int tCost = 0;
        while (pq.size() > 1) {//keep doing except the last ele ,last ele is already cal
            //pop top 2 ele from heap add into total cost
            //connect the rope and push back again in heap
            int first = pq.poll();
            int second = pq.poll();
            tCost += (first + second);
            pq.offer(first + second);

        }
        return tCost;
    }
}
