package DSA.ll;
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class RemoveDuplicateInLL {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next.next = new Node(90);

       Node result =  removeDuplicate(head);
       while(result != null){
           System.out.print(result.data+" ");
           if(result.next!=null){
               System.out.println("------>");
           }
           result=result.next;
       }

    }

    private static Node removeDuplicate(Node head) {
        Node temp = head;
        if(temp == null){
            return head;
        }
        while(temp!=null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
