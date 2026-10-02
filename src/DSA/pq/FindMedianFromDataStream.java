package DSA.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
  static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  static  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
   public static void main(String[] args) {
       FindMedianFromDataStream median = new FindMedianFromDataStream();
       median.addNum(2);
       median.addNum(3);
       median.addNum(6);

       System.out.println(median.findMedian());

    }
    public static void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    public static double findMedian() {
        if(maxHeap.size()>minHeap.size()){//odd length
            return maxHeap.peek();
        }
        return (maxHeap.peek()+minHeap.peek())/2.0d;
    }
}
