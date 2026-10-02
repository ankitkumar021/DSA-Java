package DSA.lld.customhashmap;

class Node<k,v>{
    k key;
    v val;
    Node next;
    Node prev;
    public Node(k key,v val){
        this.key=key;
        this.val=val;
    }
}
public class CustomHashMap<k,v> {
    private final int initialSize = 4;
//    private final int maxCapacity = 1<<30;//2power30{left shift}
//    private final float loadFactor = 0.75f;
    private  int countNumberOfNodes = 0;
    private Node[] map;

    CustomHashMap(){
        map = new Node[initialSize];
        for(int i=0;i<initialSize;i++){
            map[i]= new Node<>(null,null);
            map[i].next = new Node<>(null,null);
            map[i].next.prev = map[i];

        }
    }

    public v get(k key){
        Node node = findNode(key);

        if(node!=null){
            return (v)node.val;
        }
        return null;

    }
    public void put(k key,v val){
        Node node = findNode(key);

        if(node!=null){
            node.val=val;
            return;
        }

       int bucketIndex = key.hashCode()% map.length;
        Node head = map[bucketIndex];
        Node newNode = new Node<>(key,val);
        Node oldNode = head.next;
        head.next=newNode;
        newNode.prev=head;
        newNode.next=oldNode;
        oldNode.prev=newNode;

        countNumberOfNodes++;

//        //this rehashing is not necessary as per interview perspective just explain orally
//        if(countNumberOfNodes>loadFactor* map.length){
//            rehash(map.length*2);
//        }

    }
    public void remove(k key){
        Node node = findNode(key);

        if(node==null){
            return;
        }
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev =prevNode;

        countNumberOfNodes--;

    }

    public Node findNode(k key){
        int bucketIndex = key.hashCode()% map.length;//map.length=4
        Node head = map[bucketIndex];
        while(head!=null){
            if(head.key!=null && head.key.equals(key)){
                return head;
            }
            head=head.next;
        }
        return null;

    }
    public int getsize(){
        return countNumberOfNodes;

    }
/*    public void rehash(int size){

    }*/



}
