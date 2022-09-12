import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen){
            return res;
        }
        int[] S = new int[26];
        int[] P = new int[26];
        for (int i = 0; i < pLen; i++) {
            S[s.charAt(i) - 'a'] += 1;
            P[p.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(S, P)) {
            res.add(0);
        }
        for (int i = 1; i <= sLen - pLen; i++) {
            S[s.charAt(i - 1) - 'a'] -= 1;
            S[s.charAt(i + pLen - 1) - 'a'] += 1;
            if (Arrays.equals(S, P))
                res.add(i);
        }
        return res;
    }
}
