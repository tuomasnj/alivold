import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinMutation {
    public static void main(String[] args) {
        String start = "AAAAAAAA";
        String end = "CCCCCCCC";
        String[] bank = {"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA", "CCCCCCCC"};
        System.out.println(minMutation(start, end, bank));
    }

    public static int minMutation(String start, String end, String[] bank) {
        int res = 0;
        HashSet<String> path = new HashSet<>();
        HashSet<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        char[] chars = {'A', 'C', 'G', 'T'};
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            int num = 0;
            while (num < size) {
                num++;
                String cur = queue.poll();
                char[] curChar = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    for (int j = 0; j < chars.length; j++) {
                        if (cur.charAt(i) == chars[j]) {
                            continue;
                        } else {
                            curChar[i] = chars[j];
                            String next = new String(curChar);
                            if (next.equals(end) && bankSet.contains(next)) {
                                return res;
                            } else if (bankSet.contains(next) && !path.contains(next)) {
                                queue.add(next);
                                path.add(next);
                            }
                        }
                    }
                    curChar = cur.toCharArray();
                }
            }
        }
        return -1;
    }
}
