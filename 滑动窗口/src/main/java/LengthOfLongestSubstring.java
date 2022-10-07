import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = " ";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        int left = 0, right;
        for (right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))){
                set.remove((Character)s.charAt(left));
                left ++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
