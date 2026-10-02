package DSA.array.twopointer;
//“next 0 position” (low)
//“current element” (mid)
import java.util.Arrays;

public class Sort123 {
   public static void main(String[] args) {
        //int[] arr = {2,0,2,1,1,0};//
       int[] arr = {2,0,1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        int low=0;
        int mid=0;
        int high=arr.length-1;
        //here mid will where the number let mid is 0 it will pass it to low.
        //if 1 it will keep it or if 2 it will pass to 2.
        //that is the reason there is swap of number if 0,2
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
        return arr;
    }
    public static void swap(int[] arr,int low,int mid){
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
}
