public class _2024 {
    public static void main(String[] args) {
        String answerKey = "TTFTTFTT";
        int k = 1;
        int ans = maxConsecutiveAnswers(answerKey, k);
        System.out.println("最长的T为:" + ans);
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(MyMaxConsecutiveAnswers(answerKey, k, 'T'), MyMaxConsecutiveAnswers(answerKey, k, 'F'));
    }

    public static int MyMaxConsecutiveAnswers(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            if (answerKey.charAt(right) != ch) {
                sum++;
            }
            while (sum > k) {
                if (answerKey.charAt(left) != ch) {
                    sum--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
