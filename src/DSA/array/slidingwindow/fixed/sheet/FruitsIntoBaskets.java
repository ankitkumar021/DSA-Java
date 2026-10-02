package DSA.array.slidingwindow.fixed.sheet;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/fruit-into-baskets/
//https://leetcode.com/problems/
// longest-substring-with-at-most-two-distinct-characters/description/
public class FruitsIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(totalFruit(fruits));
    }
//The question is Find the longest continuous sub array that has exactly 2 distinct elements
    public static int totalFruit(int[] fruits) {
        //map is used to store distinct basket
        //constraint basket is limited to 2
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int MaxCountFruit = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            //srinking always on left pointer
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            if (map.size() <= 2) {
                MaxCountFruit = Math.max(MaxCountFruit, right - left + 1);
            }
        }
        return MaxCountFruit;
    }
}
