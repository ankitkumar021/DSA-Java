package DSA.lld.lrucache;

import java.util.HashMap;

//when we add new item it will add to the front of the list
// but if size > capacity(lru happens)
//remove from the tail
//when we access the item from list let say mid item it will come to the front.

//lru cache is the cache eviction policy

//get and put operation o(1)

//fast lookup and removal

//doubly linked list

class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head= new Node(0,0);
    Node tail = new Node(0,0);


    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size()==capacity){
            remove(tail.prev);
        }
        Node node = new Node(key,value);

        insertAtFront(node);

    }
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }
    public void insertAtFront(Node node){
        map.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
class Node{
    int key;
    int value;
    Node next;
    Node prev;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/*class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int _key,int _val){
        this.key=_key;
        this.val=_val;
    }
}

class LRUCache {
    int cap;
    Map<Integer,Node> map=new HashMap();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==cap){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);//remove from the end
            insert(node);//add at the beginning
            return node.val;
        }else{
            return -1;
        }
    }
    //HEAD ⇄ A ⇄ B ⇄ C ⇄ D ⇄ TAIL
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    //HEAD → X → A ⇄ B ⇄ C ⇄ TAIL

    public void insert(Node node){
        map.put(node.key,node);
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
    }

}*/
class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));//remove node from 2nd position to 1st
        cache.put(3, 3);//2 will be removed
        System.out.println(cache.get(2));
        cache.put(4, 4);//>capacity
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
