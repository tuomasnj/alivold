import java.util.Scanner;

public class Shousi {
    //给你一个只有0和1的字符串，代表一段连续内存。1代表该区域已使用，0代表未使用。给你一个操作次数N，
    //你可以把最多N个1变成0，求0最长能连续多少个，要求时间复杂度O（n）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        System.out.println(LongestZero(s,n));
    }

    public static int LongestZero(String s, int n) {
        int left = 0;
        int right = 0;
        int len = s.length();
        int maxLen = 0;
        while (right < len) {
            while (s.charAt(right) == '0'&& n==0){
                if(s.charAt(left)== '0'){
                    left++;
                    n++;
                }else {
                    left++;
                }
            }
            if (s.charAt(right) == '0' && n >= 1) {
                n--;
                right++;
                maxLen = Math.max(maxLen, right - left);
                continue;
            }
            right++;
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
