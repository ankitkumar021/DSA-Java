package DSA.ll;
//https://leetcode.com/problems/reorder-list/solutions/4250201/most-cleaned-approach-best-for-interview/
//https://leetcode.com/problems/reorder-list/solutions/8493297/java-zigzag-linked-list-easy-optimal-on-1tgyo/
public class ReorderList {
   public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        //  if(head==null || head.next==null) return;
        ListNode mid = middle(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;//break the list in 2half
        while(rev!=null){
            ListNode headNext = head.next;
            ListNode revNext = rev.next;

            head.next = rev;
            rev.next = headNext;
            head=headNext;
            rev=revNext;

        }

    }
    public ListNode reverse(ListNode head){
        if(head==null ||head.next==null) return head;

        ListNode reverseNode = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return reverseNode;
    }
    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
