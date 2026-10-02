package DSA.systemdesign.practicehashmap;

import DSA.lld.hashmap.HashMapImplementation;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {
    static class HashMap<k,v>{
        class Node{
            k key;
            v value;
            Node(k key,v value){
                this.key=key;
                this.value=value;
            }
        }
        int n;
        int N;
        LinkedList<Node>[] buckets;
        HashMap(int capacity){
            this.N=4;
            this.buckets=new LinkedList[4];
        }
        public int hashFunction(k key){
            int bi = key.hashCode();
            return Math.abs(bi)/N;
        }
        public int searchInLL(k key,int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;//di
                }
            }
            return -1;
        }
        public void put(k key,v value){
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);

            if(di==-1){
                buckets[di].add(new Node(key, value));
                n++;
            }else{
                Node node = buckets[bi].get(di);
                node.value=value;
            }
            //calculate load factor
            //and do rehashing
            double loadFactor = (double)n/N;

            if(loadFactor>2.0){
                //call rehashing function
            }
        }
        public v get(k key){
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);
            if(di==-1){
                return null;
            }
            else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        public boolean containsKey(k key){
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);
            if(di==-1){
                return false;
            }else{
                Node node = buckets[bi].get(di);//imp steps
/*                if(node.key==key){
                    return true;
                }*/
                return true;
            }
        }
        public v remove(k key){
            int bi= hashFunction(key);
            int di= searchInLL(key,bi);
            if(di==-1){
                return null;
            }else{
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public boolean isEmpty(){
            return n==0;
        }

        public ArrayList<k> keyset(){
            ArrayList<k> keyList = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;i<ll.size();j++){
                    keyList.add(ll.get(j).key);
                }
            }
            return keyList;
        }

    }
    public static void main(String[] args) {
        HashMapImplementation.HashMap<String,Integer> map = new HashMapImplementation.HashMap<>();
        map.put("india",200);
        map.put("usa",300);
        map.put("china",400);
        map.put("russia",500);
        map.put("italy",600);
        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }
        map.remove("usa");
        System.out.println(map.get("usa"));
    }

}
