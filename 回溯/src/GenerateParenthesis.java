import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> res =new ArrayList<>();
    static StringBuilder stringBuilder =new StringBuilder();
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n){
        int left = 0, right = 0;
        backTrack(n, left, right);
        return res;
    }
    public static void backTrack(int n, int left, int right){
        if(left > n || right > left){
            return;
        }
        if(left == n && right == n){
            res.add(new String(stringBuilder));
        }
        stringBuilder.append('(');
        backTrack(n, left + 1, right);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(')');
        backTrack(n, left, right + 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
