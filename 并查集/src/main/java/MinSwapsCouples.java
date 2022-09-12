public class MinSwapsCouples {
    public static void main(String[] args) {
        int[] row = new int[]{0, 1, 2, 3};
        System.out.println(minSwapsCouples(row));
    }

    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        U_F uf = new U_F(n);
        for (int i = 0; i < n; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - uf.count();
    }
}

class U_F {
    private int count;
    private int[] parent;

    public U_F(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /* 将 p 和 q 连通 */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootQ] = rootP;
        count--;
    }

    /* 判断 p 和 q 是否互相连通 */
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            // 进⾏路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
