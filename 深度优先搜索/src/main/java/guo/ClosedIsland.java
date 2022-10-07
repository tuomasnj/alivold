package guo;

public class ClosedIsland {
    static boolean flag = true;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 0, 0, 1, 0, 1, 0}, {
                1, 1, 1, 1, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 1, 1, 0, 0, 0, 0}, {
                1, 0, 1, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 0, 0, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 1, 1, 1, 0}, {
                1, 1, 0, 1, 0, 1, 0, 0, 1, 0}};
        System.out.println(closedIsland(arr));
    }

    public static int closedIsland(int[][] grid) {
        int ans = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !isVisited[i][j]) {
                    dfs(isVisited, i, j, grid);
                    if (flag) {
                        ans++;
                    }
                    flag = true;
                }
            }
        }
        return ans;
    }

    public static void dfs(boolean[][] isVisited, int x, int y, int[][] grid) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0) return;
        if (isVisited[x][y]) {
            return;
        }
        if (grid[x][y] == 1) {
            isVisited[x][y] = true;
            return;
        } else if (x + 1 >= grid.length || x - 1 < 0 || y + 1 >= grid[0].length || y - 1 < 0) {
            isVisited[x][y] = true;
            flag = false;
            for (int i = 0; i < dx.length; i++) {
                dfs(isVisited, x + dx[i], y + dy[i], grid);
            }
        } else {
            isVisited[x][y] = true;
            for (int i = 0; i < dx.length; i++) {
                dfs(isVisited, x + dx[i], y + dy[i], grid);
            }
        }
    }
}
