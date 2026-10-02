package revision.problemsolvingaccolite;
//algo:binary search
 /*a)Create a method/function for checking if Koko is able to eat piles of bananas
    for the given k value or not.

b). Apply binary search on min k value to max k value and check if, for the kth speed,
    Koko is able to eat banana or not.

        1) If Koko is able to eat a banana: Go to the left side of the binary search,
         for minimizing the kth value.

        2). If Koko is not able to eat a banana: Go to the right side of the binary search.*/
/*Complexity
Time complexity: O(n * log m), where m = maxPile — minPile, n = length of piles array.
Space complexity: O(1)*/
public class
KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int hour = 8;
        //output: 4
        System.out.println(minEatingSpeed(piles,hour));

    }
    private static int findMaxLimit(int[] piles){
        int maxH = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            maxH = Math.max(maxH,piles[i]);
        }
        return maxH;
    }
    private static int findHours(int[] piles,int hour){
        int totaLH=0;
        for(int i=0;i<piles.length;i++){
            totaLH +=Math.ceil((double) piles[i] / (double) hour);
        }
        return totaLH;
    }

    private static int  minEatingSpeed(int[] piles, int h) {
        int low = 1;//1 because the minimum possible eating speed is 1 banana per hour.
        int high = findMaxLimit(piles);//max(arr) since Koko never needs to eat faster than the largest pile.

        while(low<=high){
            int mid = low+(high-low)/2;
            int timeTaken = findHours(piles,mid);
            if(timeTaken<=h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}
