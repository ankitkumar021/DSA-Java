package DSA.array.slidingwindow.variable;

public class LargestSubArrayOfSumK {
   public static void main(String[] args) {
       int[] arr = {4,1,1,1,2,3,5};
       int k = 5;
       System.out.println(findLargestSubArray(arr,k));

    }
    //below solution wont work
    //actual solution is solved using prefix sum + hashmap
//how to find the size of window is:(j-i+1)
    private static int findLargestSubArray(int[] arr, int k) {
       int sum =0;
       int i=0;
       int j=0;
       int largest = 0;
       while(j<arr.length){
           sum = sum + arr[j];
           if(sum==k){
               if((j-i+1)>largest){
                   largest = j-i+1;
               }
           }
           j++;
           while(sum>k){
               sum=sum-arr[i];
               i++;
           }
       }
       return largest;

    }
}
