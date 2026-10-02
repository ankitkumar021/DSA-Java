package DSA.array.twopointer;


import java.util.Arrays;

public class RearrangeInMaxMinForm {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7};
        //Output: arr[] = {7, 1, 6, 2, 5, 3, 4}//first max than min likewise
        int [] result = rearrange(arr);
        System.out.println(Arrays.toString(result));
    }
    private static int[] rearrange(int[] arr) {
        int start=0;
        int n =arr.length-1;
        int end = n;

        int [] temp = arr.clone();

        boolean flag = true;
        for(int i=0;i<temp.length;i++){
            if(flag){
                arr[i]=temp[end--];
            }
            else {
                arr[i]=temp[start++];
            }
            flag =!flag;
        }
        return arr;
    }
}

