package DSA.array.slidingwindow.fixed;


import java.util.HashMap;

public class CountNoOfAnagram {
    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.println("2nd practice solution " + practiceP(text,word));
        System.out.println(countAnagram1(text,word));
    }
    //sliding window way
    public static int countAnagram1(String text,String word){
        // prepare frequency map by iterating over pattern
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<word.length();i++){
            mp.put(word.charAt(i),mp.getOrDefault(word.charAt(i),0)+1);
        }
        int k = word.length();
        int i=0,j=0;
        int count;
        int ans=0;
        // initialize count by size of frequency map to represent number.txt of distinct characters in pattern
        count=mp.size();
        // run till right pointer is less than length of the text string
        while(j<text.length()){
            // see if the char is there in frequency map
            if(mp.containsKey(text.charAt(j))){
                // decrease the count of frequency by 1
                mp.put(text.charAt(j),mp.get(text.charAt(j))-1);
                // check if the frequency count of the char became 0, then reduce the count as well by 1
                if(mp.get(text.charAt(j))==0){
                    count--;
                }
            }
            // see if the window side is still not reached, then increase the right pointer only
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){//// if window size is same as pattern lenght both ptr will be increased by 1
                // verify at this time if count is 0, means we are able to match the freq of all chars in freq map,
                // increase the answer by 1
                if(count==0){
                    ans++;
                }
                // now since we need to shrink the window, we need add on logic
                // find the left char of the window
                // if the left char is present in the freqMap
                // we are going to increase the frequency for this char by 1 in freq map
                // also if the freq of this char became greater than 0 this time, then we will increase
                // the count variable also by 1

/*                if(map.containsKey(tempc)){
                    if(map.get(tempc) == 0) counter++;  //need to increase counter when it first adds back to the map.
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                }*/
                if(mp.containsKey(text.charAt(i))){
                    mp.put(text.charAt(i),mp.get(text.charAt(i))+1);
                    if(mp.containsKey(text.charAt(i)>0)){//
                        count++;
                    }
                }
                // finally shift the window by sliding both pointers
                i++;
                j++;
            }
        }
        return ans;
    }
    public static int practiceP(String src, String pat){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int count = map.size();
        int k = pat.length();
        int i=0;
        int j=0;
        int ans = 0;
        while(j< src.length()){
            char ch = src.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
            }
            if(map.get(ch) == 0){
                count--;
            }
            if(j-i+1 < k){
                j++;
            }
            if(j-i+1 == k){
                if(count==0){
                    ans++;
                }
                char c = src.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.getOrDefault(c,0)+1);
                    if(map.get(c)==0){//when a new character encounter simply increase the counter
                        count++;
                    }
                }
                i++;
                j++;

            }
        }
        return ans;

    }
}
//iterative way
   /* public static boolean areAnagram(String word,String pat){
        char[] ar1 = word.toCharArray();
        char[] ar2 = pat.toCharArray();
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        if(Arrays.equals(ar1,ar2)){
            return true;
        }
        return false;
    }
    public static int countAnagram(String s1,String s2){
        int count=0;
        int N = s1.length();
        int n = s2.length();
        for(int i=0;i<=N-n;i++){
           String s = s1.substring(i,i+n);
           if(areAnagram(s2,s)){
               count++;
           }
        }
        return count;
    }*/
