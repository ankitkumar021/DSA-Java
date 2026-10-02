package DSA.array.slidingwindow.fixed.repeated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//leetcode hard://leetcode.com/problems/subarrays-with-k-different-integers/

/*Given an array of size N and an integer K, return the count of distinct numbers in all windows of size K.
Input: arr[] = {1, 2, 1, 3, 4, 2, 3}, K = 4
Output: 3 4 4 3
Explanation: First window is {1, 2, 1, 3}, count of distinct numbers is 3{1,2,3}
Second window is {2, 1, 3, 4} count of distinct numbers is 4{all}
Third window is {1, 3, 4, 2} count of distinct numbers is 4{all}
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3*/
//time=o(n)
//space=o(n)
public class CountDistinctElementInEveryWindowSizeK {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 4, 2, 3}, k = 4;
        //countDistinctWindow(arr,k);
        getTheDistinctCountInKWindowSize(arr,k);
    }
    /*So, there is an efficient solution using hashing, though hashing requires extra O(n) space
    but the time complexity will improve. The trick is to use the count of the previous window
    while sliding the window. To do this a hash map can be used that stores elements of the current window.
    The hash-map is also operated on by simultaneous addition and removal of an element while
    keeping track of distinct elements. The problem deals with finding the count of distinct elements
    in a window of length k, at any step while shifting the window and discarding all the computation done
    in the previous step, even though k – 1 elements are same from the previous adjacent window. For example,
    assume that elements from index i to i + k – 1 are stored in a Hash Map as an element-frequency pair.
    So, while updating the Hash Map in range i + 1 to i + k, reduce the frequency of the i-th element by 1
    and increase the frequency of (i + k)-th element by 1.
    Insertion and deletion from the HashMap takes constant time.*/
    //o(n)
/*    public static void countDistinctWindow(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // // Print count of first window
        System.out.println("current map size " + map.size());
        for(int i=k;i<arr.length;i++){
            // Remove first element of previous window i.e 0th elements
            // If there was only one occurrence
            if(map.get(arr[i-k])==1){
                map.remove(arr[i-k]);
            }
            //else reduce the count of removed element
            else{
                map.put(arr[i-k],map.get(arr[i-k])-1);
            }
            //else add the new element of new windows
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            // Print count of current window
            System.out.println(map.size());
        }
    }*/
    public static void getTheDistinctCountInKWindowSize(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            if (j-i+1==k) {
                list.add(map.size());
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0) {
                    map.remove(arr[i]);
                }
                i++;//slide the window
            }
            j++;//move the window
        }
        // Print results
        for (int x : list) {
            System.out.print(x + " ");
        }
    }
}
