public class _208 {
    public static void main(String[] args) {
        String s = "krrgw";
        String t = "zjxss";
        int maxCost = 19;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = 0;
        int length = s.length();
        int cost = 0;
        int result = 0;
        int count = 0;
        while (start < length) {
            while (start <= end) {
                if (end == length) break;
                cost += Math.abs(s.charAt(end) - t.charAt(end));
                if (cost <= maxCost) {
                    count++;
                    result = Math.max(result, count);
                    end++;
                } else {
                    cost -= Math.abs(s.charAt(end) - t.charAt(end));
                    break;
                }
            }
            if(count>0) {
                count--;
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            else {
                start++;
                end++;
            }
        }
        return result;
    }
}
