package DSA.array.twopointer;
//https://leetcode.com/problems/trapping-rain-water/description/
public class RainWaterTrappingUsing2Pointer {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};//9
        System.out.println(maxArea(height));
    }
    private static int maxArea(int[] height) {
        //at any index we check max on left side note or the right based which side is smaller
        //same with right side with the maximum value.
        int maxWater = 0;
        int left =0;
        int right = height.length-1;
        int leftMaxHeight=height[left];//since we are starting the max value from these index
        int rightMaxHeight=height[right];


        while(left<right){
            //if left side smaller than calculate the leftMax
            //by moving to rightside
            if(leftMaxHeight<rightMaxHeight){
                left++;
                leftMaxHeight = Math.max(leftMaxHeight,height[left]);
                maxWater += leftMaxHeight-height[left];
            }
            //right side is smaller than leftMax
            //move to left
            else{
                right--;
                rightMaxHeight = Math.max(rightMaxHeight,height[right]);
                maxWater += rightMaxHeight-height[right];
            }
        }
        return maxWater;
    }
}

/*
//brute force solution
int totalWater = 0;
        for(int i=0;i<height.length;i++){
int leftMax = 0;
int rightMax = 0;
            for(int j = 0;j<=i;j++){
leftMax = Math.max(leftMax, height[j]);
            }
                    for(int j = i;j<height.length;j++){
rightMax = Math.max(rightMax, height[j]);
            }
totalWater += Math.min(leftMax,rightMax)- height[i];
        }
        return totalWater;*/
