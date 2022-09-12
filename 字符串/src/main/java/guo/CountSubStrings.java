package guo;

public class CountSubStrings {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s){
        int count = 0;
        int size = s.length();
        boolean [][] dp= new boolean[size][size];
        for (int i = size - 1; i >= 0 ; i--) {
            for (int j = i; j < size; j++) {
                if(j - i <= 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count ++;
                }else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    count ++;
                }
            }
        }
        return count;
    }
}
