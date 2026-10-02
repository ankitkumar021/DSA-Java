package DSA.ll;

//https://leetcode.com/problems/reverse-linked-list/description/

public class ReverseLL {
   public static void main(String[] args) {
       Node head = new Node(10);
       head.next = new Node(20);
       head.next.next = new Node(30);
       head.next.next.next = new Node(40);
       head.next.next.next.next = new Node(50);
       head.next.next.next.next.next = new Node(60);
       head.next.next.next.next.next.next = new Node(70);
       head.next.next.next.next.next.next.next = new Node(80);
       Node result = reverse(head);
      //Node result =  reverseWithoutRecursion(head);
      while(result != null){
          System.out.print(result.data+" ");
          if(result.next!=null){
              System.out.print("---->");
          }
          result = result.next;
      }

    }
    public static Node reverse(Node head){
       if(head == null || head.next == null){
           return head;
       }
       Node reversedHead = reverse(head.next);
       head.next.next=head;
       head.next=null;
       return reversedHead;
    }

    public static Node reverseWithoutRecursion(Node head){
        if(head ==null || head.next == null){
            return head;
        }
        Node prev=null;
        Node curr=head;
        Node n=head.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=n;
            if(n!=null){
                n=n.next;
            }
        }
        return prev;
    }

}
