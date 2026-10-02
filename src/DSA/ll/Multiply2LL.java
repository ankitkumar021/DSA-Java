package DSA.ll;
//gfg
public class Multiply2LL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(0);

        Node head2 = new Node(1);
        head2.next = new Node(0);

        System.out.println(multiply(head,head2));

    }
    public static long multiply(Node n1,Node  n2){
        long num1 = convertToNum(n1);
        long num2 = convertToNum(n2);
        return num1*num2;
    }

    private static long convertToNum(Node node) {
        int num = 0;
        while(node != null){
            num = num*10 + node.data;
            node = node.next;
        }
        return num;
    }
}
