package DSA.stack;
//https://leetcode.com/problems/trapping-rain-water/description/
public class RainWaterTrapping {
   public static void main(String[] args) {
       int[] arr = {3,0,2,0,4};
       System.out.println(findMaxArea(arr));
       System.out.println(trap(arr));
    }

    private static int findMaxArea(int[] arr) {
       int n = arr.length;
       int[] maxl = new int[n];
       int[] maxr = new int[n];
       maxl[0] = arr[0];
       for(int i = 1;i<n;i++){
           maxl[i] = Math.max(maxl[i-1],arr[i]);
       }
       maxr[n-1] = arr[n-1];
       for(int i=n-2;i>=0;i--){
           maxr[i] = Math.max(maxr[i+1],arr[i]);
       }
       int[] water = new int[n];
        int sum = 0;
       for(int i=0;i<n;i++){
           //at any index of arr[i] what will be water store
           water[i] = Math.min(maxl[i],maxr[i]) - arr[i];
           sum = sum + water[i];
       }
       return sum;
    }
//use this solution
    public static int trap(int[] height) {
        int maxWater =0;
        int left =0;
        int right = height.length-1;
        int leftMaxHeight=height[left];//since we are starting the max value from these index
        int rightMaxHeight=height[right];
        while(left<right){
            if(leftMaxHeight<rightMaxHeight){
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, height[left]);
                maxWater +=  leftMaxHeight -height[left];
            }
            else{
                right--;
                rightMaxHeight = Math.max(rightMaxHeight,height[right]);
                maxWater += rightMaxHeight-height[right];
            }
        }
        return maxWater;

    }
}
