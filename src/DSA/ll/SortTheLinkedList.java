package DSA.ll;
//https://leetcode.com/problems/sort-list/description/?envType=problem-list-v2&envId=linked-list
public class SortTheLinkedList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
        ListNode mergeList = merge(l1, l2);

        return mergeList;

    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;//break the list in 2 part

        return slow;

    }

    public ListNode merge(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }

        return ans.next;
    }
}
