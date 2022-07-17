import java.util.HashSet;

public class _03 {
    public static void main(String[] args) {
        String str = "bbbbbb";
        System.out.println(getMaxLenOfSub(str));
    }

    public static int getMaxLenOfSub(String s) {
        if(s.equals(""))return 0;
        int len = 0;
        int left = 0, right = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(left));
        while (right < s.length()) {
            while (set.contains(s.charAt(right))) {
                len = Math.max(right - left, len);
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
        }
        len = Math.max(right - left, len);
        return len;
    }
}
