package DSA.ll;
//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLists {
   public static void main(String[] args) {

    }
 /*   public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;

        return divideLists(lists,0,lists.length-1);

    }*/
/*    public static ListNode divideLists(ListNode[] lists, int start, int end){
        if(start == end) return lists[start];
        int mid = start + (end - start)/2;
      //  Node l1 =  divideLists(lists,start,mid);
       // Node l2 =  divideLists(lists,mid+1,end);

       // return merge(l1,l2);
    }*/
    public static ListNode merge(ListNode l1 , ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
