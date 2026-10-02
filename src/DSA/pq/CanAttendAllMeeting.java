package DSA.pq;
//https://www.geeksforgeeks.org/problems/attend-all-meetings/1
import java.util.Arrays;
import java.util.PriorityQueue;

public class CanAttendAllMeeting {
    public static void main(String[] args) {
        //true case
        int arr[][] = {
                {1, 4},
                {10, 15},
                {7, 10}
        };
        System.out.println(canAttend(arr));

        //false case
        int arr1[][] = {
                {2, 4},
                {9, 12},
                {6, 10}
        };
        System.out.println(canAttend(arr1));
    }

    public static boolean canAttend(int[][] arr) {
        // code here
        if (arr.length == 0) return true;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] a : arr) {
            if (!pq.isEmpty() && pq.peek() <= a[0]) {
                pq.poll();
            }
            if (!pq.isEmpty()) {//overlap found directly return false
                return false;
            }

            pq.offer(a[1]);
        }
        return true;

    }
}
