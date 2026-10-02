package DSA.array.slidingwindow.fixed;

//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
import java.util.*;

public class FirstNegativeNumberInEveryWindowK {
    public static void main(String[] args) {
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        int k=3;
        int[] ans = getFirstNegativeInteger(arr,k);
        System.out.println(Arrays.toString(ans));

        System.out.println("using dequeue" + firstNegInt(arr,k));
    }


    public static int[] getFirstNegativeInteger(int[] arr ,int k ){
        //total sub array possible
        int[] ans = new int[arr.length-k+1];
        Queue<Integer> negative = new LinkedList<>();
        int i=0, j=0;
        int pointer=0;
        while(j<arr.length){
            if(arr[j]<0){
                negative.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if (j-i+1==k) {
                if(negative.size()==0){//can also use negative.isEmpty()
                    // if window size is reached, we need additional logic as demanded in the question
                    // if the negatives queue is empty that means no negative element encountered so far
                    // so simple add a 0 to the answer/result array
                    ans[pointer++] = 0;
                }
                else{
                    //peek does retrieve but not remove
                    ans[pointer++] = negative.peek();
                    // if the top most element is same as the left most element
                    // then also remove it from the queue
                    if(arr[i]==negative.peek()){//slide the window//fifo
                        negative.poll();
                    }

                }
                // finally increase both left and right pointers
                // to slide the window
                i++;
                j++;
            }

        }
        return ans;
    }
    public static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        Deque<Integer> negativeQueue = new LinkedList<>();
        List<Integer>ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<0){
                negativeQueue.addLast(j);//adding the array index not the value
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(negativeQueue.isEmpty()){
                    ans.add(0);
                }
                else{
                    ans.add(arr[negativeQueue.peekFirst()]);//adding the arr element
                }
                if(!negativeQueue.isEmpty() && negativeQueue.peekFirst()==i){
                    negativeQueue.removeFirst();//removing the queue element before sliding
                }

                i++;
                j++;

            }

        }
        return ans;
    }


}

