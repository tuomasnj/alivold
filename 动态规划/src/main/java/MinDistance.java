public class MinDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int distance = minDistance(word1, word2);
        System.out.println(distance);
    }
    public static  int minDistance(String word1, String word2) {
        int row = word1.length();
        int column = word2.length();
        int[][] dp =new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= column ; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= column ; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[row][column];
    }
}
