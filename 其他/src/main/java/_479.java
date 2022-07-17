public class _479 {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(2));
    }

    public static int largestPalindrome(int n) {
        if (n == 1) {
            return n;
        }
        long upper = (long) (Math.pow(10, n) - 1);
        Long num;
        for (long i = upper; i >= 0; i--) {
            String left = Long.toString(i);
            String right = new StringBuilder(left).reverse().toString();
            num = Long.valueOf(left.concat(right));
            for (long j = upper; j * j >= num; j--) {
                if (num % j == 0) return (int)(num % 1337);
            }
        }
        return -1;
    }
}
