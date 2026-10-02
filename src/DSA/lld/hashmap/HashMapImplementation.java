package DSA.lld.hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    public static class HashMap<k, v> {
        private class Node {
            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;//total number.txt nodes
        private int N;//total number.txt of buckets
        private LinkedList<Node>[] buckets;//N=buket.length//arr of buket(int [] arr)

        public HashMap() {
            this.N = 4;//default is 16
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();//empty linked is created in order to store the data
            }

        }
        //first we have store this data at some place then we have to create another one
        private void rehash() {
            LinkedList<Node> oldBuket[] = buckets;//copy the old data
            oldBuket = new LinkedList[N * 2];//size of 2*x
            for (int i = 0; i < N * 2; i++) {
                oldBuket[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBuket.length; i++) {
                LinkedList<Node> ll = oldBuket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);//method call
                }
            }
        }

        private int searchInLL(k key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;//this is basically the di
                }
            }
            return -1;
        }

        private int hashFunction(k key) {//always between 0-n-1
            int bi = key.hashCode();//but hashcode can return +ve and -ve value
            return Math.abs(bi) % N;
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {//data does not exits
                buckets[bi].add(new Node(key, value));
                n++;
            } else {//if exits
                Node node = buckets[bi].get(di);//get the di node at particular index
                node.value = value;//update the existing value with the latest value
            }
            //load factor default is 0.75 after this value is reached we do re-hashing
            double lambda = (double) n / N;//8/16=2
            if (lambda > 2.0) {
                rehash();
            }
        }

        public v get(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {//data does not exits
                return null;//return null if not present
            } else {//if exits
                Node node = buckets[bi].get(di);//get the di node at particular index
                return node.value;//return the value if present
            }
        }

        public boolean containsKey(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {//data does not exits
                return false;//return false if not present
            } else {//if exits
                Node node = buckets[bi].get(di);//get the di node at particular index
                return true;//return true if present
            }
        }

        public v remove(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {//data does not exits
                return null;//return null if not present
            } else {//if exits
                Node node = buckets[bi].remove(di);//remove the di node at particular index
                n--;
                return node.value;//return node value if present
            }
        }

        public ArrayList<k> keySet() {
            ArrayList<k> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {//bi
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("india", 200);
        map.put("usa", 300);
        map.put("china", 400);
        map.put("russia", 500);
        map.put("italy", 600);
        ArrayList<String> keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
        map.remove("usa");
        System.out.println(map.get("usa"));
    }
}

