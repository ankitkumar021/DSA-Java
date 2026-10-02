package DSA.java8.hashset.imple;

import java.util.HashMap;
import java.util.HashSet;
//map is transient so that HashSet serializes only the set elements,
// not the entire internal HashMap structure.

//why map is transient ?
//Because HashSet has its own custom serialization mechanism,
//and it does not want to store the internal HashMap structure directly.
public class HashSetImp<E> {
    private static final Object PRESENT=new Object();
    private transient HashMap map;

    public HashSetImp(HashMap map) {
        this.map = map;
    }
    // map.put(e, PRESENT) returns the previous value associated with key,
    // or null if no mapping.
    // If the return is null, the element was not present, so we return true.
    public boolean add(E e){
        return map.put(e,PRESENT)==null;
    }
    // map.remove(e) returns the value associated with key, or null if no mapping.
    // If the return is PRESENT, the element was present, so we return true.
    public boolean remove(E e){
        return map.remove(e)==PRESENT;
    }
    // Returns true if this set contains the specified element.
    public boolean contains(E e){
        return  map.containsKey(e);
    }
    //Returns the number of elements in this set.
    public int size(){
        return map.size();
    }

    public static void main(String[] args) {

        HashSet set = new HashSet<>();

        boolean b1 = set.add("geeks");
        boolean b2 = set.add("geeksforgeeks");

        //adding duplicate
        boolean b3 = set.add("geeks");

        // printing b1, b2, b3
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);


        //remove
        boolean b4 = set.remove("geeks");
        System.out.println("b4 = " + b4);

        //contains

        boolean b5 = set.contains("geeks");
        boolean b6 = set.contains("geeksforgeeks");

        System.out.println("b5 = " + b5);
        System.out.println("b6 = " + b6);

        //size

        int b7 = set.size();
        System.out.println("b7 = " + b7);

    }
}

/*        public boolean add(E e) {
            Object previousValue = map.put(e, PRESENT);

            if (previousValue == null) {
                return true;   // element was not present before
            } else {
                return false;  // element already existed in the set
            }
        }*/
/*        public boolean remove(Object o) {
            Object removedValue = map.remove(o);

            if (removedValue == PRESENT) {
                return true;   // element was present and is now removed
            } else {
                return false;  // element did not exist in the set
            }
        }*/
