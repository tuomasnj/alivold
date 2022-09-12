package guo;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int[] index = new int[2];
        int len = s.length();
        int left , right;
        int maxLen = 0;
        for (int i = 0; i < 2 * len - 1; i++) {
            left = i / 2;
            right = i / 2 + i % 2;
            while (left >= 0 && right <= len - 1 && s.charAt(left) == s.charAt(right)) {
                int pre = maxLen;
                maxLen = Math.max(right - left + 1, maxLen);
                if(maxLen != pre){
                    index[0] = left;
                    index[1] = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(index[0], index[1] + 1);
    }
}
