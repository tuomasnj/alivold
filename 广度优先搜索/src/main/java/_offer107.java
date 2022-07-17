import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _offer107 {
    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] ints = updateMatrix(mat);
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = bfs(i, j, mat, new boolean[m][n]);
            }
        }
        return res;
    }

    public static int bfs(int i, int j, int[][] mat, boolean[][] visited) {
        if (mat[i][j] == 0) {
            return 0;
        }
        int dis = 0;
        int[][] mov = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int p = 0; p < size; p++) {
                int[] poll = queue.poll();
                visited[poll[0]][poll[1]] = true;
                for (int k = 0; k < 4; k++) {
                    int[] next = new int[]{poll[0] + mov[k][0], poll[1] + mov[k][1]};
                    if (next[0] < 0 || next[0] >= mat.length || next[1] < 0 || next[1] >= mat[0].length || visited[next[0]][next[1]]) {
                        continue;
                    } else if (mat[next[0]][next[1]] == 0) {
                        return dis + 1;
                    }
                    visited[next[0]][next[1]] = true;
                    queue.offer(new int[]{next[0], next[1]});
                }
            }
            dis++;
        }
        return 0;
    }
}
