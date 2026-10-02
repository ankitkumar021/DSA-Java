package DSA.tree.bfs;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewUsingBFS {
//    public static void main(String[] args) {
//
//    }

//    public ArrayList<Integer> topView(Node root) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        TreeMap<Integer,Integer> map = new TreeMap<>();
//
//        Queue<Pair> q = new LinkedList<>();
//        q.offer(new Pair(root,0));
//        while(!q.isEmpty()){
//            Pair cur = q.poll();
//
//            //in map we are not storing the duplicate vertex(v) as these
//            //are not included in the ans
//            if(!map.containsKey(cur.v)){
//                map.put(cur.v,cur.node.data);
//            }
//
//            if(cur.node.left!=null){
//                q.offer(new Pair(cur.node.left,cur.v-1));
//            }
//            if(cur.node.right!=null){
//                q.offer(new Pair(cur.node.right,cur.v+1));
//            }
//        }
//        ans.addAll(map.values());
//        return ans;
//
//    }
//}
//class Pair{
//    Node node;
//    int v;
//    Pair(Node node,int v){
//        this.node=node;
//        this.v=v;
//    }
//}
}

