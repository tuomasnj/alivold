public class WeightBag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testWeightBagProblem(weight, value, bagWeight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[bagWeight]);
    }
}
