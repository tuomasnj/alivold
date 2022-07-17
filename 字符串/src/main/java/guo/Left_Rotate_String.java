package guo;

public class Left_Rotate_String {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String s1 = reverseLeftWords(s, 2);
        System.out.println(s1);
    }

    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, n - 1);
        reverse(sb, n, s.length() - 1);
        reverse(sb, 0, s.length() - 1);
        return new String(sb);
    }

    public static void reverse(StringBuilder stringBuilder, int begin, int end) {
        while (begin < end) {
            char ch = stringBuilder.charAt(begin);
            stringBuilder.setCharAt(begin, stringBuilder.charAt(end));
            stringBuilder.setCharAt(end, ch);
            begin++;
            end--;
        }
    }
}
