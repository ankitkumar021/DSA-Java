package DSA.array.slidingwindow.fixed.sheet;

//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
//https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr ={2,5,1,8,2,9,1};
        int k =3;
        System.out.println("using for loop " + maxSubarraySum(arr,k));
        //  System.out.println(findMaxSubArraySumWithDistinctElement(arr,k));
        System.out.println(findMaxSumByTakingKConsecutively(arr,k));
        //  System.out.println(findMaxSubArraySumWithDuplicateElement(arr,k));
    }
    public static int maxSubarraySum(int[] arr, int k) {
        // Code here
        int maxSum=0;
        int l=0;
        int sum =0;
        for(int r=0;r<arr.length;r++){
            sum += arr[r];

            //shrink condition should be first than condition met
            if(r-l+1 > k){
                sum = sum-arr[l];
                l++;
            }

            //when window reached
            if(r-l+1 == k){
                maxSum = Math.max(sum,maxSum);
            }

        }
        return maxSum;//in-case of average divide by k
    }
    //using sliding way o(n)
    private static int findMaxSubArraySumWithDistinctElement(int[] arr, int k){
        int i=0;
        int j=0;
        int sum =0;
        int maxSum =Integer.MIN_VALUE;
        while(j<arr.length){
            sum = sum+arr[j];
            if(j-i+1==k){//2-0+1=k(3)
                maxSum = Math.max(maxSum,sum);
                sum = sum-arr[i];//before slide minus the element at
                i++;//slide the window
            }
            j++;
        }
        return maxSum;
        /* *//*if (arr.length < k)
        {
            System.out.println("Invalid");
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i=k; i<arr.length; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }*//*

        return res;*/
    }
    public static int findMaxSumByTakingKConsecutively(int[] arr,int k){
        int l=0;
        int r=k-1;
        int sum =0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<=r;i++){
            sum = sum+arr[i];
        }
        while(r<arr.length-1){
            sum=sum-arr[l];
            l++;
            r++;
            sum=sum+arr[r];
            maxSum= Math.max(maxSum,sum);

        }
        return maxSum;

    }
    //leetcode question medium
   /* private static int findMaxSubArraySumWithDuplicateElement(int[] arr, int k){
        int i=0;
        int j=0;
        int sum =0;
        int maxSum =0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<arr.length){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);//add the element to the map
            sum = sum+arr[j];//add the eleemnt to the local sum
            if(j-i+1==k){//if the  window size is equal to k
                //if the windows size = k that means there are distinct k elemnet
                if(map.size()==k){
                    maxSum = Math.max(maxSum,sum);//take max sum
                }
                sum = sum-arr[i];//remove the calculution of arr[i]
                //remove arr[i] from map .if arr[i] is duplicate in window
                //decrease the frequency by 1
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;//shift the window to right
            }
            j++;//expand the window
        }
        return maxSum;
    }
*/
}

//simple iterative way o(n2)
  /*  private static int findMaxSum(int[] arr, int k) {
        int maxSum =0;
        for(int i=0;i+k<arr.length;i++){
            int tempSum =0;
            for(int j=i;j<i+k;j++){
                tempSum = tempSum+arr[j];
            }
            if(tempSum>maxSum){
                maxSum=tempSum;
            }
        }
        return maxSum;
    }*/

