import java.util.Arrays;

public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int size = envelopes.length;
        int[] dp = new int[size + 1];
        dp[1] = 1;
        Arrays.sort(envelopes,(o1, o2) -> (o1[0] - o2[0]));
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if (envelopes[j -1][0] < envelopes[i - 1][0] && envelopes[j - 1][1] < envelopes[i - 1][1]) {
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                } else{
                    continue;
                }
            }
            if(dp[i] == 0){
                dp[i] = 1;
            }
        }
        Arrays.sort(dp);
        return dp[size];
    }
}
