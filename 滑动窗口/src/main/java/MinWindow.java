import java.util.HashMap;
import java.util.Set;

public class MinWindow {
    public static void main(String[] args) {
        String s = "a";
        String t = "aaa";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right;
        HashMap<Character, Integer> big = new HashMap<>();
        HashMap<Character, Integer> small = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            small.put(t.charAt(i), small.getOrDefault(t.charAt(i), 0) + 1);
        }
        int sLen = s.length();
        for (right = 0; right <= sLen; right++) {
            while (check(big, small)) {
                if (big.get(s.charAt(left)) == 1) {
                    big.remove(s.charAt(left));
                } else {
                    big.put(s.charAt(left), big.get(s.charAt(left)) - 1);
                }
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    res = s.substring(left, right);
                }
                left++;
            }
            if (right < sLen) {
                big.put(s.charAt(right), big.getOrDefault(s.charAt(right), 0) + 1);
            }
        }
        return res;
    }

    public static boolean check(HashMap<Character, Integer> big, HashMap<Character, Integer> small) {
        Set<Character> characters = small.keySet();
        for (Character c : characters) {
            if (big.getOrDefault(c, 0) < small.get(c)) {
                return false;
            }
        }
        return true;
    }
}
