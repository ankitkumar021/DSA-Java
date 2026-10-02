package DSA.interval;

import java.util.Arrays;
//https://leetcode.com/problems/non-overlapping-intervals/
public class MinNumOfIntervalRemovalToMakeNonOverlapping {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
      //  Arrays.sort(intervals, (a, b) -> a[1] - b[1]);//using lamda
        //(+)->a is greater,(-)->a is smaller,if(0)->both are equal
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prev_index = intervals[0][1];//meaning {1, 2}->2 is assigned
        //in this loop we compare last index of a pair with curr pair 1st index
        for (int i = 1; i < intervals.length; i++) {
            if (prev_index > intervals[i][0]) {
                count++;
            } else {
                prev_index = intervals[i][1];
            }
        }
        return count;

    }
}

//commented leetcode solution is below
/*
public int eraseOverlapIntervals(int[][] intervals) {
    //sorting based on last index
    //this will helps us to compare to the next pair start time
    Arrays.sort(intervals,(a,b) -> a[1] - b[1]);

    int prev_end = intervals[0][1];
    int count =0;

    for(int i =1;i<intervals.length;i++){
        //if my prev_end is> current start
        //count++;
        //possible meeting
        //you can all apply anoly to meeting there is diff in cond
        //prev_end is< current start
        //total - count will ans
        if(prev_end>intervals[i][0]){
            count++;
        }else{
            //update the prev_end
            prev_end = intervals[i][1];
        }

    }
    return count ;

}*/
