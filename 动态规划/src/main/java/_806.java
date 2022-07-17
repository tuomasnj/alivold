import java.util.*;

public class _806 {
    public static void main(String[] args) {
        int[] width = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "aaa";
        List<String> list=new ArrayList<>();
        list.add(s);s=null;
        System.out.println(list.get(0));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int length = s.length();
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int wid = widths[s.charAt(i-1) - 'a'];
            if (dp[i - 1] + wid > 100) {
                dp[i] = wid;
                line++;
            } else {
                dp[i] = dp[i - 1] + wid;
            }
        }
        return new int[]{line,dp[length]};
    }
}
