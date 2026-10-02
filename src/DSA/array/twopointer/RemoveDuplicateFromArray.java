package DSA.array.twopointer;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicateFromArray {
   public static void main(String[] args) {
       int[] arr = {1,1,2,3,3,4,4};
       int newSize = remove(arr);
       for(int i = 0;i<newSize;i++){
           System.out.println((arr[i]));
       }
    }
    public static int remove(int[] arr){
       int j=0;
       for(int i=1;i<arr.length;i++){
           if(arr[i]!=arr[j]){
               j++;
               arr[j]=arr[i];
           }
       }
       return j+1;
    }
}
