package guo;

public class OneEditAway {
    static int[][] mem;
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println(oneEditAway(s1, s2));
    }

    public static boolean oneEditAway(String first, String second) {
        mem = new int[first.length()][second.length()];
        if (dfs(first.toCharArray(), first.length() - 1, second.toCharArray(), second.length() - 1) <= 1) {
            return true;
        }
        return false;
    }

    public static int dfs(char[] ch1, int x, char[] ch2, int y) {
        if (x == -1 || y <= -1) {
            return Math.max(x, y) + 1;
        }
        if (ch1[x] == ch2[y]) {
            return dfs(ch1, x - 1, ch2, y - 1);
        } else {
            if(mem[x][y] != 0){
                return mem[x][y];
            }
            int ans = Math.min(dfs(ch1, x - 1, ch2, y - 1) + 1,
                    Math.min(dfs(ch1, x - 1, ch2, y) + 1, dfs(ch1, x, ch2, y - 1) + 1));
            mem[x][y] = ans;
            return ans;
        }
    }
}
