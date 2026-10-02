package DSA.dp.blind75missed;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "12";//2->A,B(1,2) orL(12)
        //String s ="06";//0->as start with 0
        System.out.println(numDecodings(s));

    }
    public static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;//empty string
        //if string with 0 means invalid case(1 for(1->9))
        dp[1] = s.charAt(0) == '0' ? 0 :1;

        for(int i=2;i<=n;i++){
            int oneDigit = Integer.valueOf(s.substring(i-1,i));
            int twoDigit = Integer.valueOf(s.substring(i-2,i));

            if(oneDigit>=1){
                dp[i] += dp[i-1];
            }
            if(twoDigit>=10 && twoDigit<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
