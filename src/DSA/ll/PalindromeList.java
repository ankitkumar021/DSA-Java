package DSA.ll;
//https://leetcode.com/problems/palindrome-linked-list/?envType=problem-list-v2&envId=linked-list
import java.util.Stack;

public class PalindromeList {
   public static void main(String[] args) {

    }
    //time :0(n)
    //spcae:0(1)
    public boolean isPalindrome(ListNode head) {

        ListNode mid = middle(head);
        ListNode midReverse = reverse(mid);
        ListNode temp = midReverse;
        while(head!=null && midReverse!=null){
            if(head.val != midReverse.val){
                return false;
                // break;
            }
            head = head.next;
            midReverse = midReverse.next;
        }
        reverse(temp);

        return true;

    }
    public ListNode reverse(ListNode head){
        if(head== null || head.next==null) return head;

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
    //time :0(n)
    //spcae:0(n)
    public boolean isPalindromeUsingStack(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode cur = head;
        while(cur!=null){
            st.push(cur.val);
            cur = cur.next;
        }
        cur= head;
        while(cur!=null && st.pop() == cur.val){
            cur= cur.next;
        }
        return cur==null;

    }
}
