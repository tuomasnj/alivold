import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> res = new ArrayList<>();
    static List<Character> storeLeft = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backTrack(sb, n, 0, 0);
        return res;
    }

    public static void backTrack(StringBuilder sb, int n, int left, int right) {
        if (left > n) {
            return;
        }
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        sb.append('(');
        storeLeft.add('(');
        backTrack(sb, n, left + 1, right);
        sb.deleteCharAt(sb.length() - 1);
        storeLeft.remove(storeLeft.size() - 1);
        if (storeLeft.size() > 0) {
            sb.append(')');
            storeLeft.remove(storeLeft.size() - 1);
            backTrack(sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
            storeLeft.add('(');
        }
    }
}
