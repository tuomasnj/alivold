import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = new String("pwwkew");
        System.out.println(LengthOfLongestSubstring(str));
    }

    public static int LengthOfLongestSubstring(String str) {
        HashSet<Character> set =new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        for (right = 0; right  < str.length(); right++) {
            while (set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left ++;
            }
            set.add(str.charAt(right));
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
