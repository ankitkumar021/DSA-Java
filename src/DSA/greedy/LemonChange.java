package DSA.greedy;
//https://leetcode.com/problems/lemonade-change/
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
