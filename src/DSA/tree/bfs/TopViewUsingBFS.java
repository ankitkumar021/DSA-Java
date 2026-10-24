package DSA.tree.bfs;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewUsingBFS {
//    public static void main(String[] args) {
    //divide the tree into 2 parts like x and y axis
    //and root will be vertex 0, left node will -1 and right vertex will be +1
    //store all the like for -1:{10,20,80} ,-2,+1,+2...
    // so only the first node will added in the ans ex:{10,20,30}->only 10 will be added
    //for that treemap will be used.

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

