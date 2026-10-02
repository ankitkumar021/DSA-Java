package DSA.graph;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                                        {1,1,0},
                                        {1,1,0},
                                        {0,0,1}
                                        };
        System.out.println(findCircleNum(isConnected));

    }
    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int[] visited = new int[isConnected.length];
        for(int i=0;i<isConnected.length;i++){//going all the nodes{index}
            if(visited[i] == 0){
                dfs(i,isConnected,visited);
                provinces++;
            }
        }
        return provinces;
    }
    public static void dfs(int node,int[][] isConnected,int[] visited){
        visited[node] = 1;

        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i] == 1 && visited[i] != 1){//initially node[1,1,0]
                //mark it visited and recursively call dfs
                visited[i] = 1;
                dfs(i,isConnected,visited);
            }
        }
    }
}
