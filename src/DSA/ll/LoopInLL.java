package DSA.ll;
//https://leetcode.com/problems/linked-list-cycle/description/
public class LoopInLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(30);
        //head.next.next = new Node(30);
        head.next.next = new Node(40);
/*        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(50);
        head.next.next.next.next.next.next.next = new Node(60);*/
        head.next.next.next = head.next;
       boolean result =  isLoop(head);
        System.out.println(result);
    }

    private static boolean isLoop(Node head) {
/*        if(head == null){
            return true;
        }*/
        Node slow = head;
        Node fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
