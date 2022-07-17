package guo;

public class _547 {
    public static void main(String[] args) {
        //创建二维数组
        int[][] isConnected = new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
