package revision.problemsolvingaccolite;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,0,3};
        System.out.println(findEqui(arr));
        System.out.println(revision(arr));
    }
    private static int findEqui(int[] arr) {
        int prefSum = 0;
        int total = 0;
        for(int num : arr){
            total += num;
        }
        for(int pivot =0;pivot<arr.length;pivot++){
            int suffixSum = total-prefSum-arr[pivot];
            if(prefSum==suffixSum){
                return pivot;
            }
            prefSum +=arr[pivot];
        }
        return -1;
    }
    public static int revision(int[] arr){
        int prev=0;
        int next=0;
        int totalSum=0;
        for(int num:arr){
            totalSum +=num;
        }
        for(int pivot =0;pivot<arr.length;pivot++){
            next = totalSum-arr[pivot]-prev;
            if(prev==next){
                return pivot;
            }
            prev +=arr[pivot];
        }

        return -1;
    }










}
