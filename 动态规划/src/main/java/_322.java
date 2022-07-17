import java.util.Arrays;

public class _322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            if(coin<=amount)
            dp[coin] = 1;
        }
        for (int coin : coins)
            for (int i = coin; i <= amount; i++) {
                {
                    dp[i] = Math.min(dp[i - coin] + 1 < 0 ? dp[i - coin] : dp[i - coin] + 1, dp[i]);
                }
            }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
