import java.util.*;

public class NetWorkDelayTime {
    public static void main(String[] args) {
        int[][] netWorkDelayTime = {{1,2,1}, {2, 3, 7}, {1, 3, 4},{2,1,2}};
        int n = 3;
        int k = 2;
        System.out.println(netWorkDelayTime(netWorkDelayTime, n, k));
    }

    public static int netWorkDelayTime(int[][] times, int n, int k) {
        int[] results = new int[n];
        Arrays.fill(results, Integer.MAX_VALUE);
        results[k - 1] = 0;
        while (true) {
            boolean end = true;
            for (int[] time : times) {
                if (results[time[0] - 1] == Integer.MAX_VALUE) continue;
                if (results[time[0] - 1] + time[2] >= results[time[1] - 1]) continue;
                results[time[1] - 1] = results[time[0] - 1] + time[2];
                end = false;
            }
            if (end) break;
        }
        int num = Arrays.stream(results).max().getAsInt();
        return num == Integer.MAX_VALUE ? -1 : num;
    }
}
