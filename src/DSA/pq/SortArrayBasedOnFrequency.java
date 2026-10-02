package DSA.pq;
//https://leetcode.com/problems/sort-array-by-increasing-frequency/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayBasedOnFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 1,1, 2, 2, 2, 3};
        //Output: [3,1,1,2,2,2]
        //Explanation: '3' has a frequency of 1,
        // '1' has a frequency of 2, and '2' has a frequency of 3.
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        //custom sorting
        //at line number 14 if frequency is equal sort based on arr ele
        //else sort based on frequency

        //java comparator work lik below
        //(a,b)
        //(+) means b is greater
        //(-) means a is greater
        //(0) both are equal
        //b-a means i want bigger number not the frequencies

        return Arrays.stream(nums).boxed().
                sorted((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b)).
                mapToInt(n -> n).
                toArray();
    }
}
/*
Initialize an unordered map freq to store the frequency of each integer in the input array nums.
Traverse through each integer num in the array nums.
Increase the count of num in the freq map using freq[num]++.
Sort the array nums using the sort function with a custom comparator:
Compare two integers a and b based on their frequencies stored in the freq map:
If freq[a] (frequency of a) equals freq[b] (frequency of b), then:
Return a > b to ensure that in case of tie-in frequency, larger values come first (decreasing order).
Otherwise, return freq[a] < freq[b] to sort by frequency in increasing order.*/
/*
class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        // Convert numsObj back to a primitive array to match
        // return type.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}*/
