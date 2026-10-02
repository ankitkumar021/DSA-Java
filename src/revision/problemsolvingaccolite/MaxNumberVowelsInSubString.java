package revision.problemsolvingaccolite;

public class MaxNumberVowelsInSubString {
   public static void main(String[] args) {
       String s = "aeiou";
       int k = 2;
       System.out.println(findMaxVowels(s,k));
    }
    private static boolean isVowel(char c){
       return c =='a'||c =='e'||c =='i'||c =='o'||c =='u';
    }

    private static int findMaxVowels(String s,int k) {
       int l=0;
       int r =0;
       int maxVowelCount = 0;
       int windowCount=0;
       while(r<s.length()){
           if(isVowel(s.charAt(r))){
               windowCount++;
           }
           if((r-l+1)>k){
               if(isVowel(s.charAt(l))){
                   windowCount--;
               }
               l++;
           }
           if((r-l+1)==k){
               maxVowelCount = Math.max(maxVowelCount,windowCount);
           }
           r++;
       }
       return maxVowelCount;
    }
}
