package sde.bs;

public class FindPositionToInsertElement {
    public static void main(String[] args) {
        int[] arr =  {1, 2, 3, 4, 6};
        int x=5;
        System.out.println(findPos(arr,x));
    }
    public static int findPos(int[] arr,int x){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==x){
                return mid;
            }
            else if(arr[mid]<x){
                start =mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}
