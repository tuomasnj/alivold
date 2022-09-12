import java.util.Scanner;

public class ShortestTravelTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        sc.nextLine();
        int num = sc.nextInt();
        float[][] nums = new float[num + 2][2];
        sc.nextLine();

        int count = 1;
        while (count <= num) {
            nums[count][0] = sc.nextFloat() / 100;
            nums[count][1] = sc.nextInt();
            count++;
        }
        nums[count][0] = distance / 100;
        System.out.println((int)shortestTravelTime(nums));
    }

    public static float shortestTravelTime(float[][] nums) {
        float[][] dp = new float[nums.length][2];
        for (float[] a : dp) {
            a[0] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 10;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i][0] - nums[j][0] <= dp[j][1]) {
                    if (j == 0) {
                        dp[i][0] = Math.min(dp[i][0], dp[j][0] + nums[j][1] + nums[i][0] - nums[j][0]);
                    }else {
                        dp[i][0] = Math.min(dp[i][0], 1 + dp[j][0] + nums[j][1] + nums[i][0] - nums[j][0]);
                    }
                    dp[i][1] = 10;
                }
            }
        }
        return dp[dp.length - 1][0] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1][0];
    }
}
