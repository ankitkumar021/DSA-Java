package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
public class MinSpeedToArriveOnTime {
    public static void main(String[] args) {
        int[] dist = {1,3,2};
        int hour  = 6;
/*        Explanation: At speed 1:
        - The first train ride takes 1/1 = 1 hour.
                - Since we are already at an integer hour, we depart immediately at the 1 hour mark. The second train takes 3/1 = 3 hours.
                - Since we are already at an integer hour, we depart immediately at the 4 hour mark. The third train takes 2/1 = 2 hours.
                - You will arrive at exactly the 6 hour mark.*/
        System.out.println(minSpeedOnTime(dist,hour));
    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        int s = 1;
        int e = (int)1e7;
        int ans = -1;

        while(s<=e){
            int m = s+(e-s)/2;//speed

            if(checkValidSpeed(dist,hour,m)){
                ans = m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    public static boolean checkValidSpeed(int[] dist,double hour,int speed){
        double time =0.0;
        for(int i=0;i<dist.length;i++){
            double t = (double)dist[i]/speed;

            if(i!= dist.length-1){
                time +=Math.ceil(t);//keep add ceil for the time
            }else{//last index we do not have next train to cal time so directly ad
                time +=t;
            }

        }
        return time<=hour;
    }
}
