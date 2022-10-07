import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int res = orangesRotting(grid);
        System.out.println(res);
    }

    public static int orangesRotting(int[][] grid) {
        int total = 0;
        int time = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        if (total == 0) return 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            int num = 0;
            time++;
            while (num++ < size) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int curX = cur[0];
                    int curY = cur[1];
                    int nextNodeX = curX + dx[i];
                    int nextNodeY = curY + dy[i];
                    if (nextNodeX < 0 || nextNodeX >= grid.length || nextNodeY < 0
                            || nextNodeY >= grid[0].length || visit[nextNodeX][nextNodeY]) {
                        continue;
                    } else if (grid[nextNodeX][nextNodeY] == 1) {
                        visit[nextNodeX][nextNodeY] = true;
                        total--;
                        if (total == 0) {
                            return time;
                        }
                        queue.add(new int[]{nextNodeX, nextNodeY});
                    } else if (grid[nextNodeX][nextNodeY] == 0) {
                        visit[nextNodeX][nextNodeY] = true;
                    } else {
                        visit[nextNodeX][nextNodeY] = true;
                        queue.add(new int[]{nextNodeX, nextNodeY});
                    }
                }
            }
        }
        return -1;
    }
}
