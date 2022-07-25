public class _72 {
    public static void main(String[] args) {
        String s1 ="intention";
        String s2 = "execution";
        System.out.println(minDistance(s1, s2));
    }
    public static int minDistance(String word1, String word2){
        int[][] dp =new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length() ; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
