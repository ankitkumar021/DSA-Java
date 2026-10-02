package DSA.pq;

public class Mergeksortedlists {
    static void main(String[] args) {

    }
/*    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val -b.val);
        for(ListNode list : lists){
            if(list!=null){
                pq.offer(list);
            }
        }
        ListNode dumy = new ListNode(-1);
        ListNode temp = dumy;
        while(!pq.isEmpty()){
            ListNode l = pq.poll();
            temp.next = l;
            temp = temp.next;
            if(l.next!=null){
                pq.offer(l.next);
            }
        }

        return dumy.next;
    }*/
}
