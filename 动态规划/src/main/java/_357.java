public class _357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(7));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        int pre = 9;
        for (int i = 2; i < n + 1; i++) {
            pre *= (9 - i + 2);
            dp[i] = dp[i - 1] + pre;
        }
        return dp[n];
    }
}
