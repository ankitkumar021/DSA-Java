package DSA.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfEleBetweenK1thSmallestK2Smallest {
    public static void main(String[] args) {
        int[] arr = {1,3,12,5,15,11};
        int k1=3;
        int k2=6;
        System.out.println(sumBetweenTwoKth(arr,k1,k2));
    }
    public static int sumBetweenTwoKth(int[] arr,int k1,int k2){

        int first = kSmallest(arr,k1);
        int second = kSmallest(arr,k2);

        int total = 0;

/*        Arrays.sort(arr);

        for(int i=k1;i<k2-1;i++){

            total +=arr[i];

        }*/
        //the above code is for gfg test case
        for(int i=0;i<arr.length;i++){
            if(arr[i]>first && arr[i]<second){
                total +=arr[i];
            }
        }
        return total;

    }
    public static int kSmallest(int[] arr,int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n:arr){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
