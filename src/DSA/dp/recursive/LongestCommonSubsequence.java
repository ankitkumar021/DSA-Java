package DSA.dp.recursive;

//
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        //recursive way->getting TLE
        int n = text1.length();
        int m = text2.length();

        return lcs(text1,text2,n,m);

    }
    public static int lcs(String text1, String text2,int n,int m){
        //base case
        if(n==0 || m==0) return 0;

        //choice diagram
        if(text1.charAt(n-1) == text2.charAt(m-1)){//start comparing the last char
            return 1+lcs(text1,text2,n-1,m-1);
        }

        //if last character is not matched ,take or not take from both
        else{
            return Math.max(lcs(text1,text2,n-1,m),lcs(text1,text2,n,m-1));
        }


    }
}
