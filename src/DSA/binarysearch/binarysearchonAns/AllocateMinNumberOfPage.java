package DSA.binarysearch.binarysearchonAns;
//make sure this solution is not submitted on gfg
//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
public class AllocateMinNumberOfPage {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr,k));
    }
    public static int findPages(int[] arr, int k) {
        int len = arr.length;
        if(k>len) return -1;
        int s = 0;
        int e = 0;
        for(int n: arr){
            s=Math.max(s,n);
            e +=n;
        }
        int ans =e;
        while(s<=e){
            int m = s+(e-s);//page
            if(checkAllocation(arr,k,m)){
                ans = m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    public static boolean checkAllocation(int[] arr,int k,int m){
        int page=1;
        int sum =0;
        for(int i=0;i<arr.length;i++){

            if(sum+arr[i]<=m){
                sum +=arr[i];
            }else{
                page++;
                sum = arr[i];
            }
        }
        return page<=k;
    }
}
