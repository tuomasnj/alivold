import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String str) {
        if (str.length() <= 12) {
            backTrack(str, 0, new ArrayList<>());
        }
        ArrayList<String> strings = new ArrayList<>();
        for (List<String> list : res) {
            StringBuilder append = new StringBuilder();
            for (String s : list) {
                append.append(s).append(".");
            }
            append.deleteCharAt(append.length() - 1);
            strings.add(new String(append));
        }
        return strings;
    }

    public static void backTrack(String s, int start, List<String> temp) {
        if (temp.size() == 4 && start == s.length()) {
            res.add(new ArrayList(temp));
        }
        for (int i = start + 1; i <= start + 3; i++) {
            if (i > s.length()) {
                return;
            }
            String cur = s.substring(start, i);
            if (cur.startsWith("0") && cur.length() > 1 || Integer.parseInt(cur) > 255) {
                break;
            } else {
                temp.add(cur);
                backTrack(s, i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
