package DSA.ll;
//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumber {
   public static void main(String[] args) {
       Node head = new Node(2);
       head.next = new Node(4);
       head.next.next = new Node(3);

       Node head2 = new Node(5);
       head2.next = new Node(6);
       head2.next.next = new Node(4);

       //342 + 465 = 807.
       //output : 708
       Node result = add(head,head2);
       while(result != null){
           System.out.print(result.data+" ");
           result = result.next;
       }
    }
    private static Node add(Node head, Node head2) {
       Node temp = new Node(-1);
       Node cur = temp;
       int carry = 0;
       while(head!=null || head2!=null || carry ==1){
           int sum = 0;
           if(head!=null){
               sum += head.data;
               head = head.next;
           }
           if(head2!=null){
               sum += head2.data;
               head2 = head2.next;
           }
            sum +=carry;
            carry = sum/10;
            Node newNode = new Node(sum%10);//as we have to return linked
            cur.next = newNode;
            cur = cur.next;
       }
       return temp.next;
    }
}
