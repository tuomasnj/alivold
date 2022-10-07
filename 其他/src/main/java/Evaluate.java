import java.sql.Array;
import java.util.*;

public class Evaluate {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = Arrays.asList(Arrays.asList("name", "bob"), Arrays.asList("age", "two"));
        System.out.println(s.matches("\\(name\\)"));
        System.out.println(evaluate(s, knowledge));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                StringBuilder key = new StringBuilder();
                while (chars[++i] != ')') {
                    key.append(chars[i]);
                }
                sb.append(map.getOrDefault(key.toString(), "?"));
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
