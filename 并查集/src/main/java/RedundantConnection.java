import java.util.Arrays;

public class RedundantConnection {
    private int n; //节点数量设置为 3 到 1000
    private int[] father;
    public RedundantConnection(){
        n = 1005;
        father = new int[n];

        //并查集初始化
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    //在并查集中寻找根
    private int find(int u){
        if(u == father[u]){
            return u;
        }
        father[u] = find(father[u]);
        return father[u];
    }
    // 将v->u 这条边加入并查集
    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return ;
        father[v] = u;
    }

    // 判断 u 和 v是否找到同一个根，本题用不上
    private Boolean same(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public int[] findRedundantConnection(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1])) {
                return edges[i];
            } else  {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{2,3},{4,3},{1,3}};
        RedundantConnection redundantConnection = new RedundantConnection();
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));
    }
}
