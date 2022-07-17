package guo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizes {
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        System.out.println(Arrays.toString(pondSizes(land)));
    }

    public static int[] pondSizes(int[][] land) {
        boolean[][] vis = new boolean[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int size =dfs(land, vis, i ,j);
                if(size != 0) {
                    ans.add(size);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public static int dfs(int[][] land, boolean[][] vis, int i, int j) {
        if (i < 0 || j < 0 || i >= land.length || j >= land[0].length) {
            return 0;
        }
        if (vis[i][j]) {
            return 0;
        } else {
            vis[i][j] = true;
            if (land[i][j] == 0) {
                return 1 + dfs(land, vis, i + 1, j) +
                        dfs(land, vis, i, j + 1) + dfs(land, vis, i + 1, j + 1)
                        + dfs(land, vis, i - 1, j - 1) + dfs(land, vis, i - 1, j) +dfs(land, vis, i, j - 1)
                        + dfs(land, vis, i - 1, j + 1) +dfs(land, vis, i + 1, j - 1);
            } else{
                return 0;
            }
        }
    }
}
