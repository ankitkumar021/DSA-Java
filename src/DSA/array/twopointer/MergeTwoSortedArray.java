package DSA.array.twopointer;
//https://leetcode.com/problems/merge-sorted-array/
import java.util.Arrays;

public class MergeTwoSortedArray {
  public static void main(String[] args) {
      int[] a = {1,2,3,4,5,6};
      int[] b = {7,8,10};
      System.out.println(Arrays.toString(merge(a, b)));
     // System.out.println("2nd solution : " + Arrays.toString(mergeTwoSortedArray(a,b)));
    }
    private static int[] merge(int[] a, int[] b) {
      int i=0;
      int j=0;
      int k=0;
      int n1=a.length;
      int n2=b.length;
      int[] merge = new int[n1+n2];
      while(i<n1 && j<n2){
          if(a[i]<=b[j]){
              merge[k++]=a[i++];
          }else{
              merge[k++]=b[j++];
          }
      }
        while(i<n1){
            merge[k++]=a[i++];
        }
        while(j<n2){
            merge[k++]=b[j++];
        }
      return merge;
    }



/*//practice
    public static int[] mergeTwoSortedArray(int[] a, int[] b){
      int i=0;
      int j=0;
      int k=0;
      int n1 = a.length;
      int n2 = b.length;
      int[] m = new int[n1+n2];
      while(i<n1 && j<n2){
          if(a[i]<=b[j]){
              m[k++]=a[i++];
          }
          else if(b[j]<a[i]){
              m[k++]=b[j++];
          }
          while(i<n1){
              m[k++]=a[i++];
          }
          while(j<n2){
              m[k++]=b[j++];
          }
      }
      return m;
    }*/
}
