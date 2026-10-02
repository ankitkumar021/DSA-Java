package DSA.recursion.divideAndConquer;
//https://www.geeksforgeeks.org/problems/merge-sort/1
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {40,20,30,10,50};
        int low=0;
        int high=arr.length-1;
        sort(arr,low,high);
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    public static void sort(int[] arr,int low,int high){
        if(low>=high){//when size 1
            return;
        }
            int mid = low+(high-low)/2;
            sort(arr,low,mid);//left subarray
            sort(arr,mid+1,high);//right subarray,at this point we know array is divided into 1 subarray
            merge(arr,low,mid,high);

    }
    private static void merge(int[] arr,int low,int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i=0;i<n1;i++){
            left[i] = arr[low+i];

        }
        for(int j=0;j<n2;j++){
            right[j] = arr[mid +1 +j];

        }
        int i=0;
        int j=0;
        int k=low;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }else{
                arr[k++]=right[j++];
            }
        }
        while(i<n1){
            arr[k++]=left[i++];

        }
        while(j<n2){
            arr[k++]=right[j++];
        }
    }

 /*   private static void merge(int[] arr,int low,int mid, int high){
        //merge 2 subarray of arr into the original array
        int[] merge = new int[high-low+1];
        int i =low;
        int j = mid+1;
        int k =0;
        while(i<=mid && j<=high ){    //here we can take 2 array or we can also use 2 index
            if(arr[i]<=arr[j]){
                merge[k++]=arr[i++];
            } else {
                merge[k++]=arr[j++];
            }
        }
        while(i<=mid){
            merge[k++]=arr[i++];
        }
        while(j<=high){
            merge[k++]=arr[j++];
        }
        //at the end copy from temp to original array
        for(i=low;i<=high;i++){
            arr[i]=merge[i-low];
        }
    }*/
}
