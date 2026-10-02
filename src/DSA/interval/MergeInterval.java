package DSA.interval;

import java.util.Arrays;
import java.util.LinkedList;
//https://leetcode.com/problems/merge-intervals/

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.toString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        //sort the start index
        //compare 2nd index ele of current interval >= 1st index of next interval
        //we need to update the 2nd index if,2nd index is < than 2nd index of next
        //interval
        //how do you check if current pair is already in the interval for this
        //check last ele of current pair with last index of interval
        //if they current pair last index <= last index of pair
        //that means it is already there

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merge = new LinkedList<>();


        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merge.isEmpty() || merge.getLast()[1] < interval[0]) {
                merge.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);

            }

        }
        //convert it into an array
        return merge.toArray(new int[merge.size()][]);

    }
}
