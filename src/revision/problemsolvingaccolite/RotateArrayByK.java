package revision.problemsolvingaccolite;
//https://www.geeksforgeeks.org/dsa/print-array-after-it-is-right-rotated-k-times/
//Using Recursion - O(n × k) Time and O(k) Space

//k%n
//It's is done because if
//k is larger than nums.length it would do a cycle that would be useless
// so its written to reduce
// the calculation and logic correction
public class RotateArrayByK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        rotateArray(arr,k);
        for(int num : arr){
            System.out.print(num + " " );
        }
    }
    private static void rotateArray(int[] arr,int k) {
        if(k==0 || arr.length==0){
            return ;
        }
        int n = arr.length;
        int temp = arr[n-1];//4
        for(int i = n-1;i>0;i--){
            arr[i]=arr[i-1];//
        }
        arr[0]=temp;
        rotateArray(arr,k-1);
    }

    //1234
    //output:3412
    //reverse(arr,0,n-1);//4321
    //reverse(arr,0,k-1);
    //reverse(arr,k,n-1);
}
