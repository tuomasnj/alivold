import java.util.Arrays;
import java.util.Scanner;

public class GoodString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(count(s));
    }

    public static int count(String str) {
        int res = 0;
        int[] arr = new int[26];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            Arrays.fill(arr, 0);
            for (int j = i; j < len; j += 2) {
                arr[str.charAt(j) - 'a'] += 1;
                if (calOne(arr) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int calOne(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                res++;
            }
        }
        return res;
    }
}


