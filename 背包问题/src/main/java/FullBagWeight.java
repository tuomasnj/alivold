public class FullBagWeight {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value ={15,20,30};
        int bagWeight = 4;
        System.out.println(testCompletePack01(weight, value, bagWeight));
        System.out.println(testCompletePack02(weight, value, bagWeight));
    }
    //先遍历物品，再遍历背包容量
    public static int testCompletePack01(int[] weight, int[] value, int bagWeight){
        int[] dp =new int[bagWeight + 1];
        //先遍历物品
        for (int i = 0; i < weight.length; i++) {
            //再遍历背包容量
            for (int j = weight[i]; j <= bagWeight  ; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }

    //先遍历背包容量，再遍历物品
    public static int testCompletePack02(int[] weight, int[] value, int bagWeight){
        int[] dp =new int[bagWeight + 1];
        //先遍历背包容量
        for (int i = 1; i <= bagWeight ; i++) {
            //再遍历物品
            for (int j = 0; j < weight.length ; j++) {
                if(i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i -weight[j]] + value[j]);
                }
            }
        }
        return dp[bagWeight];
    }

}
