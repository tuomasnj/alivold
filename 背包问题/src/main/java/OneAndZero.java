public class OneAndZero {
    public static void main(String[] args) {
        String[] strs={"10", "0001", "111001", "1", "0"};
        int m =5;
        int n =3;
        System.out.println(findMaxForm(strs, m, n));
    }

    /**
     *这道题目依然是01背包问题
     * 不过不同于之前的问题，本题的背包有两个维度，一个是m，一个是n。所以是一个多目标容量的背包问题
     * 而不同长度的字符串就是不同大小的待装物品
     * 并且每个物品对应的价值value都为1
     */
    public static int findMaxForm(String[] strs, int m, int n){
        int [][]dp = new int[m+1][n+1];
        dp[0][0] =0;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < strs.length; i++) {
             String item = strs[i];
            for (int j = 0; j < item.length(); j++) {
                if(item.charAt(j) == '0'){
                    zeros ++;
                }
                if(item.charAt(j) == '1'){
                    ones ++;
                }
            }
            for (int j = m; j - zeros >= 0 ; j--) {
                for (int k = n; k -ones >= 0 ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
            zeros = 0;
            ones = 0;
        }
        return dp[m][n];
    }
}
