package guo;

public class IntegerReplacement {
    public static void main(String[] args) {
        long a = 2147483647;
        System.out.println(integerReplacement(a));
    }
    public static int integerReplacement(long n) {
        return dfs(n);
    }
    public static int dfs(long num) {
        if (num == 1) {
            return 0;
        }
        if (num % 2 == 1) {
            return Math.min(dfs(num - 1), dfs(num + 1)) + 1;
        }else {
            return dfs(num / 2) + 1;
        }
    }
}
