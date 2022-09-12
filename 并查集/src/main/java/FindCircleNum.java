public class FindCircleNum {
    static int count;
    static int[] parent;
    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected){
        count = isConnected.length;
        parent= new int[count];
        for (int i = 0; i < isConnected.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1 && i!= j){
                    union(i, j);
                }
            }
        }
        return count;
    }

    //如果两棵树被连通则合并两个节点，就将其中一棵树的根节点设置为另一颗树的根节点.
    public static void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    //查找节点x对应的根节点，如果parent[x] == x 则说明根节点为x
    public static int find(int x){
        while (parent[x] != x){
            parent[x] = parent[parent[x]]; //路径压缩
            x = parent[x];
        }
        return x;
    }
}
