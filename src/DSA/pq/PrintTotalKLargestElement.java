package DSA.pq;
//https://www.geeksforgeeks.org/dsa/k-largestor-smallest-elements-in-an-array/
import java.util.PriorityQueue;
//total k = if k =3 ,print all the element
public class PrintTotalKLargestElement {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        printK(arr,k);

    }

    private static void printK(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n :arr) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();

            }
        }
        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.poll();
        }

    }
}
