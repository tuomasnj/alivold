public class MaxRepOpt1 {
    public static void main(String[] args) {
        String text = "aabbaba";
        System.out.println(maxRepOpt1(text));
    }

    public static int maxRepOpt1(String text) {
        int res = 0, n = text.length();
        int left = 0, right;
        int[] sumCount = new int[26];
        for (char a : text.toCharArray()) {
            sumCount[a - 'a']++;
        }
        int[] window = new int[26];
        int numInWindow = 0;
        char tmpMax = ' ';
        for (right = 0; right < n; right++) {
            if (numInWindow < ++window[text.charAt(right) - 'a']) {
                numInWindow = window[text.charAt(right) - 'a'];
                tmpMax = text.charAt(right);
            }
            while (right - left > numInWindow) {
                window[text.charAt(left) - 'a']--;
                int curMaxAmount = 0;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return Math.min(res, sumCount[tmpMax - 'a']);
    }
}
