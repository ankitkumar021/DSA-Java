package DSA.dp.blind75missed;
//https://github.com/nikoo28/java-solutions/blob/master/src/main/java/leetcode/medium/WordBreak.java
//https://leetcode.com/problems/word-break/

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
       String s = "leetcode";
       //List<String> wordDict = Arrays.asList("leet","code");
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(wordBreak(s,wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // catsandog ->
        // cats + an + dog
        // cats + and + og
        // cat + sand + og
        // and many like that..
        // Not all words are present in the list:
        // wordDict = ["cats","dog","sand","and","cat"]

        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);//for O(1) lookup

        boolean[] dp = new boolean[n+1];
        dp[0]=true;

        for(int i=1;i<=n;i++){
            //this loop is for keep previous index in dp if the substring is
            //present in the dictionary is already marked if it true than update
            //the index with true .
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
