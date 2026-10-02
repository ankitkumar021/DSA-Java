package DSA.greedy;
//https://leetcode.com/problems/gas-station/description/
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};//2,3,4
        int[] cost = {3,4,5,1,2};//3,4,3

        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG=0;
        int totalC=0;
        int start=0;
        int currentGas=0;

        for(int g: gas){
            totalG +=g;
        }
        for(int c: cost){
            totalC +=c;
        }

        if(totalG < totalC){
            return -1;
        }

        for(int i=0;i<gas.length;i++){
            currentGas += (gas[i] - cost[i]);
            if(currentGas < 0){
                currentGas = 0;
                start = i+1;
            }
        }

        return start;
    }
}
