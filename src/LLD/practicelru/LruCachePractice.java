package LLD.practicelru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCachePractice<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public LruCachePractice( int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public boolean removeEldestEntry(Map.Entry<K,V> oldest){
        return size()>capacity;
    }

    public void printCache(){
        System.out.println(this);
    }

    public static void main(String[] args) {

        LruCachePractice<String,Integer> cache = new LruCachePractice<>(2);

        cache.put("ankit",1);
        cache.put("abhi",2);

        cache.printCache();

        cache.put("abhay",3);

        cache.printCache();

        cache.get("abhay");


        cache.put("aw",4);
        cache.printCache();

    }
}
