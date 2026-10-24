package DSA.greedy;
//https://leetcode.com/problems/lemonade-change/
//At a lemonade stand, each lemonade costs $5.
//Customers are standing in a queue to buy from you and order one at a time
//(in the order specified by bills). Each customer will only buy one lemonade and
//pay with either a $5, $10, or $20 bill. You must provide the
//correct change to each customer so that the net transaction is that the customer pays $5.
public class LemonChange {
    public static void main(String[] args) {
        int[] bills ={5,5,5,10,20};//true
       // int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills) {

        int fiveD = 0;
        int tenD = 0;

        for(int n : bills){
            if(n == 5){
                fiveD++;
            }
            else if(n == 10){
                // We need to give $5 change
                if(fiveD > 0){
                    fiveD--;
                    tenD++;
                }else{
                    return false;//cant provide change
                }
            }else{
                // We need to give $15 change
                if(fiveD > 0 && tenD > 0){
                    fiveD--;
                    tenD--;
                }else if(fiveD >= 3){//we need 3 five dollars
                    fiveD -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
