package DSA.pq;

import java.util.PriorityQueue;

//https://leetcode.com/problems/reorganize-string/description/
public class ReorganiseString {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
    public static String reorganizeString(String s) {
        //blocking->so that no 2 char comes first
        //highest frequency priority(will consider first)//maxHeap
        //which maintain the count of character
        int[] f = new int[26];
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            f[c-'a']++;
            if( f[c-'a'] > (s.length()+1)/2){
                return "";
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> (b.freq - a.freq));
        for(int i=0;i<26;i++){
            if(f[i]>0){
                pq.add(new pair((char)('a'+i),f[i]));
            }
        }
        StringBuilder res = new StringBuilder();
        pair block = pq.poll();
        res.append(block.ch);
        block.freq--;
        while(pq.size()>0){
            pair temp = pq.poll();
            res.append(temp.ch);
            temp.freq--;
            if(block.freq>0){
                pq.offer(block);
            }
            block=temp;
        }
        return res.toString();
    }
}
class pair{
    char ch ;
    int freq;
    pair(char ch ,int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
