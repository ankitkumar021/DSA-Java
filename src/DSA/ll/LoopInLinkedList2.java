package DSA.ll;
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class LoopInLinkedList2 {
  public   static void main(String[] args) {

    }
    //we have to returned the start Node of the loop
    // 🐢 Use a slow pointer moving one step at a time.
    // 🐇 Use a fast pointer moving two steps at a time.
    // 🔁 If a cycle exists, they will eventually meet inside the cycle.
    // 🎯 Once they meet, reset slow to head.
    // 🚶 Move both slow and fast one step at a time.
    // 📍 They will meet exactly at the start of the cycle.
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){//here we know ok there is cycle but we don't know the node
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;//or fast both can be returned
            }
        }
        return null;
    }

}

