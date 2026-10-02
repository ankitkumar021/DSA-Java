package DSA.pq;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://github.com/eMahtab/meeting-rooms-ii
//https://www.geeksforgeeks.org/problems/attend-all-meetings-ii/1
public class MinimumNumberOfMeetingRoom {
    public static void main(String[] args) {
        int[] start = {1, 10, 7};
        int[] end = {4, 15, 10};
        System.out.println(minMeetingRooms(start,end));
    }
    public static int minMeetingRooms(int[] start, int[] end) {
        //create a pair first
        int n = start.length;
        int[][] meeting = new int[n][2];

        for (int i = 0; i < n; i++) {
            meeting[i][0] = start[i];
            meeting[i][1] = end[i];
        }
        //(1,4),(7,10)(10,15)
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] meet : meeting) {
            if (!pq.isEmpty() && pq.peek() <= meet[0]) {
                pq.poll();
            }
            pq.offer(meet[1]);
        }
        return pq.size();
    }
}
