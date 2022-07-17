import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _105 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,1}};
        for(int[] c:grid){
            System.out.println(Arrays.toString(c));
        }
        int res = maxAreaOfIsland(grid);
        System.out.println(res);
        for(int[] c:grid){
            System.out.println(Arrays.toString(c));
        }
    }
        public static int maxAreaOfIsland (int[][] grid){
            int[] dx={-1,1,0,0};
            int[] dy={0,0,1,-1};
            int m=grid.length;
            int n=grid[0].length;
            int maxArea=0;
            Queue<int[]> queue=new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int temp=0;
                    if(grid[i][j]==1){
                        queue.offer(new int[]{i,j});
                        grid[i][j]=2;
                        temp++;
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int x = poll[0]+ dx[k];
                                int y = poll[1] + dy[k];
                                if ((0 <= x && x <= m - 1) && (0 <= y && y <= n - 1) && grid[x][y] == 1) {
                                    queue.offer(new int[]{x, y});
                                    grid[x][y] = 2;
                                    temp++;
                                }
                            }
                        }
                        maxArea=Math.max(maxArea,temp);
                    }
                }
            }
            return maxArea;
        }
    }
