package inteview.mock;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
   public static void main(String[] args) {
       int n = 100;
       //9,90,99
       int[] arr = {1,20,38,5,10,2};

      // System.out.println(Arrays.toString(print(arr)));

       String base ="ankit";
       String reg ="akienet";
       System.out.println(printRemoveChar(base,reg));
       //System.out.println(printRemove(base,reg));

    }
    public static List<Character> printRemoveChar(String base, String reg) {
        int i = 0;
        int j = 0;
        char[] first = base.toCharArray();
        char[] second = reg.toCharArray();
        List<Character> ans = new ArrayList<>();

        while (i < first.length  && j < second.length ) {
            if (first[i] == second[j] ) {
                i++;
                j++;
            } else{
                //System.out.println(first[i]);
                ans.add(first[i]);
                ans.add(second[j]);
                i++;
                j++;
            }
            while(i<first.length){
                ans.add(first[i]);
                i++;

            }
            while(j<second.length){
                ans.add(second[j]);
                j++;

            }

        }
        return ans;


    }
     /*   public static int[] print(int[] arr){

       int first=0;
       int last=arr.length-1;
       while(first<=last){

           int temp = arr[last];
           arr[last]=arr[first];
           arr[first]=temp;
           first++;
           last--;
       }
       return arr;

    }*/
}
