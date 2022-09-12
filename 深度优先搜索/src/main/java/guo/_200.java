package guo;

import java.util.ArrayList;
import java.util.Arrays;

public class _200 {
    static int dis;
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(Arrays.toString(numIslands(grid)));
    }

    public static int[] numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ArrayList<Integer> x = new ArrayList<>();
                    ArrayList<Integer> y = new ArrayList<>();
                    dfs(grid, i, j, x, y);
                    count++;
                }
            }
        }
        return new int[]{count, dis};
    }

    public static void dfs(char[][] grid, int i, int j, ArrayList<Integer> x, ArrayList<Integer> y) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        x.add(i);y.add(j);
        for (int k = 0; k < x.size(); k++) {
            dis = Math.max(Math.abs(i - x.get(k)) + Math.abs(j - y.get(k)), dis);
        }
        dfs(grid, i, j + 1, x, y);
        dfs(grid, i, j - 1, x, y);
        dfs(grid, i + 1, j, x, y);
        dfs(grid, i - 1, j, x, y);
    }
}
