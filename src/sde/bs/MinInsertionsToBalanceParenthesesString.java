package sde.bs;
//ctrl+r
public class MinInsertionsToBalanceParenthesesString {
   public static void main(String[] args) {
     //  String s = "))()))(()))";
       String s = "(()))";
       System.out.println(minInsertions(s));

    }

    private static int minInsertions(String s) {
       int requiredBracket=0;
       int missingClosed =0;
       for(char c : s.toCharArray()){
           if(c=='('){
               requiredBracket +=2;
               if(requiredBracket%2!=0){
                   missingClosed++;//adding closed )
                   requiredBracket--;//decrease count ) as adding make pair
               }
           }else{
               requiredBracket -=1;
               if(requiredBracket<0){
                   missingClosed++;
                   requiredBracket +=2;
               }
           }
       }
       return missingClosed+requiredBracket;
    }
}
