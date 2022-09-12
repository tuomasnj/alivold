import java.util.Arrays;

public class CalculateMiniHP {
    public static void main(String[] args) {
        int[][] mesh = {{0, 0, 0}, {1, 1, -1}};
        System.out.println(calculateMiniHP(mesh));
    }

    public static int calculateMiniHP(int[][] mesh) {
        int m = mesh.length;
        int n = mesh[0].length;
        int[][] dp = new int[m][n];
        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = mesh[m - 1][n - 1] > 0 ? 1 : -mesh[m - 1][n - 1] + 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                if (j == n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] - mesh[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] - mesh[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i + 1][j] - mesh[i][j], dp[i][j + 1] -mesh[i][j]));
                }
                dp[i][j] = dp[i][j] <= 0 ? 1 : dp[i][j];
            }
        }
        return dp[0][0];
    }
}
