package DSA.lld.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    protected final int capacity ;
    public LRUCacheImpLinkedHashMap(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K,V> oldest){
        return  size()>capacity;
    }
    public void printCache(){
        System.out.println("entry " + this);
    }

}

 class Lru {
    public static void main(String[] args) {
        LRUCacheImpLinkedHashMap<Integer,String> cache = new LRUCacheImpLinkedHashMap<>(3);
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        //cache.removeEldestEntry()


        // Cache order (LRU -> MRU): 1,2,3
        cache.printCache();// {1=One, 2=Two, 3=Three}

        // Cache order: 1,3,2
        cache.get(2);
        cache.printCache(); // {1=One, 3=Three, 2=Two}

        // Insert 4 → exceeds capacity → evict LRU (1)
        cache.put(4, "Four");

        // Cache order: 3,2,4
        cache.printCache(); // {3=Three, 2=Two, 4=Four}

    }
}

