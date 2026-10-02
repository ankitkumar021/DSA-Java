package DSA.binarysearch.binarysearchonAns;
//https://leetcode.com/problems/magnetic-force-between-two-balls/description/
import java.util.Arrays;

public class MagneticForceBetweenTwoBall {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position,m));
    }
    public static int maxDistance(int[] position, int m) {
        //aggressive cow
        Arrays.sort(position);
        int n = position.length-1;
        int s = 1;
        int e = position[n] - position[0];
        int ans =0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(checkPos(position,m,mid)){
                ans = mid;
                s=mid+1;

            }else{
                e=mid-1;
            }
        }
        return ans;
    }
    public static boolean checkPos(int[] position,int m,int mid){
        int ball =1;
        int last=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-last >=mid){
                ball++;
                last = position[i];
            }
            if(ball>=m) return true;
        }
        return false;
    }
}
