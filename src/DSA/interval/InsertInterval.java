package DSA.interval;
//https://leetcode.com/problems/insert-interval/description/
import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
  public  static void main(String[] args) {
      int[][] intervals ={{1,3},{6,9}};
      int[] newInterval = {2,5};
      System.out.println(insert(intervals,newInterval));

  }
  public static int[][] insert(int[][] intervals, int[] newInterval){
      //o(n)

      int i=0;
      List<int[]> list = new ArrayList<>();
      int n = intervals.length;

      //no overlapping
      //think of adjusting whether my newInterval is adjust or not by checking
      while(i<n && intervals[i][1] < newInterval[0]){
          list.add(intervals[i]);
          i++;
      }

      //overlapping and merging
      while(i<n && intervals[i][0] <= newInterval[1]){
          newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
          newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
          i++;
      }
      list.add(newInterval);

      //no overlapping after merging
      while(i<n){
          list.add(intervals[i]);
          i++;
      }
      //below code convert into array with no of rows = list size
      return   list.toArray(new int[list.size()][]);

  }
}
