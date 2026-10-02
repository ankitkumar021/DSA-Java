package DSA.array.slidingwindow.fixed.sheet;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxInSlidingWindowK(nums, k)));

    }

    private static int[] maxInSlidingWindowK(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int j = 0;
        int[] maxArr = new int[nums.length - k + 1];
        int ptr = 0;
        while (j < nums.length) {
            //removing all the element from queue which smaller than curr inserting element
            while (!deque.isEmpty() && nums[j] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[j]);
            if (j - i + 1 < k) {
                j++;
            }
            else if (j - i + 1 == k) {

                //  maximum ele at the front of the queue
                maxArr[ptr++] = deque.peekFirst();

                //slide
                //before slide check if the current array ele is present at the front of list
                //or not if yes we have to remove it
                if (nums[i] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                j++;
                i++;
            }
        }
        return maxArr;
    }
}

/*
       for(int right =0;right<nums.length;right++){
        //removing all the element from queue which smaller than curr inserting element
        while(!d.isEmpty() && d.peekLast()<=nums[right]){
        d.pollLast();
            }
                    d.add(nums[right]);
            if(right-left+1<k){
left++;
        }
        if(right-left+1 == k){
//maximum ele at the front of the list
maxArr[ptr++] = d.peekFirst();

//slide
//before slide check if the current array ele is present at the front of list
//or not if yes we have remove it

                if(nums[left] == d.peekFirst()){
        d.pollFirst();
                }
left++;

        }

        }
        return maxArr;*/
