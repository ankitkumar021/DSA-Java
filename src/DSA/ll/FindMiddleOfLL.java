package DSA.ll;
//https://leetcode.com/problems/middle-of-the-linked-list/
public class FindMiddleOfLL {
   public static void main(String[] args) {
       Node head = new Node(10);
       head.next = new Node(20);
       head.next.next = new Node(30);
       head.next.next.next = new Node(40);
       head.next.next.next.next = new Node(50);
       head.next.next.next.next.next = new Node(60);
       head.next.next.next.next.next.next = new Node(70);
       head.next.next.next.next.next.next.next = new Node(80);
       Node result  = find(head);
       System.out.println(result.data);

    }
    public static Node find(Node head){
       if(head == null){
           return null;
       }
       Node fast = head;
       Node slow = head;
       while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;//both even and odd it will workd
    }
}
