package DSA.binarysearch.binarysearchonAns;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums,k));
    }
    public static int splitArray(int[] nums, int k) {
        int s = 0;
        int e = 0;
        for(int n :nums){
            s = Math.max(s,n);
            e +=n;
        }
        int ans = e;
        while(s<=e){
            int m = s+(e-s)/2;
            if(isPossibleSplit(nums,k,m)){
                ans = m;
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return ans;

    }
    public static boolean isPossibleSplit(int[] arr,int k,int m){
        int curSum = 0;
        int group =1;
        for(int num: arr){
            if(curSum+num <=m){
                curSum += num;
            }else{
                group++;
                curSum = num;
            }
        }
        return group<=k;
    }
}
