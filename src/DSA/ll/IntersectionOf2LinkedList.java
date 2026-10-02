package DSA.ll;
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOf2LinkedList {
   public static void main(String[] args) {

    }
    //in these problem don't think if 1 list becomes means
    //there is not intersection point there can be different length of lists is there
    //so 1 become null assign to other head vice versa
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode h1= headA;
        ListNode h2 = headB;

        while(h1 != h2){
            if(h1 == null){
                h1 = headB;
            }
            else{
                h1 = h1.next;
            }
            if(h2 == null){
                h2 = headA;
            }
            else{
                h2 = h2.next;
            }
        }
        return h1;

    }
}
