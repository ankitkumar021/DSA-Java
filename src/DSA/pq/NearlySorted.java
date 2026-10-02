package DSA.pq;

import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/dsa/nearly-sorted-algorithm/
//https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
//*
public class NearlySorted {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4};
        int k = 2;
        //System.out.println(nearlySorted(arr,k));
       nearlySorted(arr,k);
        for (int x : arr)
            System.out.print(x + " ");
    }
    public static void nearlySorted(int[] arr, int k) {
        // code here
        //min heap
        //we are using min element as we wanted array to sorted
        //we are sorting k integer at once
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int j =0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if(pq.size()>k){
                arr[j]=pq.peek();
                pq.poll();
                j++;
            }
        }

        while(!pq.isEmpty()){
            arr[j]=pq.poll();
            j++;
        }
    }
}

/*        public static List<Integer> nearlySorted(int[] arr, int k) {
            // code here
            //min heap
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<Integer> list = new ArrayList<>();

            for(int n: arr){
                pq.offer(n);
                if(pq.size()>k){
                    list.add(pq.poll());
                }
            }
            while(!pq.isEmpty()){
                list.add(pq.poll());
            }
            return list;
        }*/
