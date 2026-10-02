package DSA.array.twopointer;
//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
//two pointer is generally used when array is sorted to decide which pointer to move
//but here when array is not sorted then also we can apply it
    //a = l*b=2*3,since width is decreasing after every iteration which is deciding point
    //to apply the 2 pointer to move
    //since we max area so if(height[left]<=height[right] left++;

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int h = Math.min(height[left],height[right]);
            int width = right-left;
            int area = h*width;
            maxArea = Math.max(maxArea,area);

            if(height[left]<=height[right]){//pointer which is min increase that
                left++;
            }else{
                right--;
            }
        }
        return maxArea;

    }
}
