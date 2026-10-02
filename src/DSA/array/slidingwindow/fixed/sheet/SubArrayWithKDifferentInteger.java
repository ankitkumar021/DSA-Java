package DSA.array.slidingwindow.fixed.sheet;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/description/
//an array where the number of different integers in that array is exactly k.
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//same question as fruits in the basket

public class SubArrayWithKDifferentInteger {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        // exactly(K) = atMost(K) - atMost(K-1)
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public static int atMostK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            //when we reach at any index of nums[right],the total length is the no of subarray
            count += right - left + 1;//size of subarray

        }
        return count;
    }
}
