public class Main5 {
    /**
     * 找到字符串s中的最长回文子串
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "babad";
        String str = longestPalindrome(s);
        System.out.println(str);
    }

    public static String longestPalindrome(String s) {
        int[] mark = new int[2];//用于存放左、右指针
        int len = s.length();
        int curLongest = 0;
        for (int i = 0; i <= 2 * len - 2; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right <= len - 1 && s.charAt(left) == s.charAt(right)) {
                if (curLongest < right - left + 1) {
                    mark[0] = left;
                    mark[1] = right;
                    curLongest = right - left +1;
                }
                left--;
                right++;
            }
        }
        return s.substring(mark[0], mark[1] + 1);
    }
}
