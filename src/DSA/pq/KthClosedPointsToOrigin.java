package DSA.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/description/
/*       Output: [[-2,2]]
       Explanation:
       The distance between (1, 3) and the origin is sqrt(10).
               The distance between (-2, 2) and the origin is sqrt(8).
               Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
               We only want the closest k = 1 points from the origin,
                so the answer is just [[-2,2]].*/
public class KthClosedPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        System.out.println(Arrays.toString(kClosest(points, k)));
    }
    public static int[][] kClosest(int[][] points, int k) {
        //max priority queue
        //if you understand which pq is used try sample dataset
        //and see both

        //distance = x*x + y*y
        //why b come first than a because its a max heap

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2[0] * p2[0] + p2[1] * p2[1],
                        p1[0] * p1[0] + p1[1] * p1[1])
        );

        for (int[] arr : points) {
            pq.offer(arr);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];//column is fixed 2
        while (k > 0) {
            res[--k] = pq.poll();

        }
        return res;

    }
}
