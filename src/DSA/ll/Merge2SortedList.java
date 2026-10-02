package DSA.ll;
//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class Merge2SortedList {
   public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode temp = new ListNode(-1);
        ListNode ans = temp;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                ans.next = list1;
                list1 = list1.next;
                ans = ans.next;
            }else {
                ans.next = list2;
                list2 = list2.next;
                ans = ans.next;
            }
            //check if any list is empty
            ans.next = list1!=null?list1:list2;

        }
        return temp.next;

    }
}
