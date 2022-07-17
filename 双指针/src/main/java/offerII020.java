/**
 * 计算字符串中回文子字符串的个数
 * 中心拓展
 */
public class offerII020 {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i <= 2 * len - 2; i++) {
            int le = i / 2;
            int ri = i / 2 + i % 2;
            while (le >= 0 && ri < len && s.charAt(le) == s.charAt(ri)) {
                count++;
                le--;
                ri++;
            }
        }
        return count;
    }
}
