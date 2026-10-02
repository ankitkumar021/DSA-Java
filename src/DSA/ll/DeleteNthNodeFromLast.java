package DSA.ll;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class DeleteNthNodeFromLast {
    public static int counter=0;
    public static void main(String[] args) {
        Node head = new Node(10);
/*        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(80);*/
        int n=1;
        Node result  = delete(head,n);
        System.out.println(result);
        if(result!=null){
            Node curr = result;
            System.out.println(n + "--->" + " if cur is null return null " + curr.data);
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }

        }

    }
/*    static class Counter{
        int count=0;
    }*/
    public static Node delete(Node head,int n){
        if(head==null || head.next == null){
            return null;
        }
        Node deleteNode = delete(head.next,n);
        if(++counter==n){
            return head.next;//skip the node
        }
        head.next = deleteNode;
        return head;
    }
/*    public static Node delete(Node head,int n){
        if(head==null){
            return null;
        }
        Node deleteNode = delete(head.next,n);
        if(++counter==n){
            return head;
        }
        return deleteNode;
    }*/
/*    public static void printNode(Node head){
        if(head==null){
            return;
        }
        System.out.println(head.data);
        while(head.next!=null){
            System.out.println("------>");
            head = head.next;
        }
    }*/
}
