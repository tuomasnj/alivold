public class _47 {
    public static void main(String[] args) {
        int[][] num={{1,3,1},{1,5,1},{4,2,1}};
        int i = maxValue(num);
        System.out.println(i);
    }
    public static int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j>=1){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else if(j==0 && i>=1){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }
                else if(i>=1 && j>=1){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
