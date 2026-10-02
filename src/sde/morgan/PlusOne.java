package sde.morgan;
//Mental model (remember this)
//
//arr[i] = 0 → happens only when digit is 9
//
//arr[i]++ + return → carry is finished, stop everything
import java.util.Arrays;

public class PlusOne {
   public static void main(String[] args) {
       int[] arr1 = {1, 3, 9};
       int[] arr2 = {9, 9, 9};
       System.out.println(Arrays.toString(plusOne(arr1))); // [1, 4, 0]
       System.out.println(Arrays.toString(plusOne(arr2))); // [1, 0, 0, 0]

    }
    public static int[] plusOne(int[] arr){
       //139+1->140
        //999+1=1000
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<9){
              arr[i]++;// <-- carry is consumed HERE
              return arr;
            }
            arr[i]=0;// because 9 + 1 becomes 0 with carry
        }
        int[] res = new int[arr.length+1];//we have created this array and default val is 0.
        res[0]=1;//just append 1 at the start
        return res;
    }
}
