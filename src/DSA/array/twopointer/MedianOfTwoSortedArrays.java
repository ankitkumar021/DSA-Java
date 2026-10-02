package DSA.array.twopointer;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2 = nums2.length;

        int[] m = new int[n1+n2];

        int i=0;
        int j=0;
        int k=0;

        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                m[k++] = nums1[i++];
            }else{
                m[k++] = nums2[j++];
            }
        }
        while(i<n1){
            m[k++] = nums1[i++];
        }
        while(j<n2){
            m[k++] = nums2[j++];
        }

        int n = m.length;

        if(n%2==1){
            // If the total number of elements is odd, return the middle element as the median.
            return (double)m[n/2];
        }
        else{
            // If the total number of elements is even, calculate the average of the two middle elements as the median
            int mid1 =m[n/2-1];
            int mid2 =m[n/2];
            return ((double) mid1+(double)mid2)/2.0;

        }

    }
}
