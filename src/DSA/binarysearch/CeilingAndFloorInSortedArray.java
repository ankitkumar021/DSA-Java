package DSA.binarysearch;
//https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
public class CeilingAndFloorInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        System.out.println(findCeil(arr,x));
        System.out.println(findFloor(arr,x));
    }
    public static int findCeil(int[] arr, int x) {
        // code here
        int s=0;
        int e=arr.length-1;
        int ans=-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m] >= x){
                ans = m;
                e=m-1;

            }else{
                s=m+1;
            }
        }
        return ans;
    }
  public  static int findFloor(int[] arr, int x) {
        // code here
        int s=0;
        int e=arr.length-1;
        int ans =-1;
        while(s<=e){
            int m= s+(e-s)/2;
            if(arr[m]<= x){
                s=m+1;
                ans=m;
            }else{
                e=m-1;
            }
        }
        return ans;
    }
}
