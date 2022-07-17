import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = generateParenthesis(6);
        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        dfs(n, "",0,0);
        return res;
    }

    public static void dfs(int n, String s, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (left == right && left == n) {
            res.add(s);
        }
        dfs(n, s + "(", left + 1, right);
        dfs(n, s + ")", left, right + 1);
    }
}
