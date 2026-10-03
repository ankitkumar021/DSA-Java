package LLD.practicelru;

import java.util.HashMap;
import java.util.Map;

//insertion will happen at the front
//delete at happens at the back
class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class LruCache {
    private int capacity;
    private Map<Integer, Node> cacheMap;

    private Node head;
    private Node tail;

    LruCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void put(int key, int value) {
        //if key is present remove that node
        if (cacheMap.containsKey(key)) {
            Node oldNode = cacheMap.get(key);
            remove(oldNode);
        }
        //create a node with latest value
        Node newNode = new Node(key, value);
        // updates will happen at the hashmap and linked list both
        cacheMap.put(key, newNode);
        add(newNode);

        if (cacheMap.size() > capacity) {
            Node nodeToDelete = tail.prev;//imp tail is pointing to last node
            //remove will happen from map and list both
            remove(nodeToDelete);
            cacheMap.remove(nodeToDelete.key);
        }

    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        remove(node);//remove from last
        add(node);//add to the start
        return node.value;

    }

    public void remove(Node node) {
        //remove from middle kind of things
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void add(Node node) {
        Node nextNode = head.next;//keep the already node before insertion
        head.next = node;//head will point to new node
        node.prev = head;//add just the pointer of new node
        node.next = nextNode;
        nextNode.prev = node;//connect the prev node to new node
    }

}

class Main {
    public static void main(String[] args) {
        LruCache cache = new LruCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));//remove node from 2nd position to 1st
        cache.put(3, 3);//2 will be removed
        System.out.println(cache.get(2));
        cache.put(4, 4);//>capacity
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

/*        1
                -1
                -1
        3
        4*/

    }

}
