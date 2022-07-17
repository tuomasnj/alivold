import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _139 {
    public static void main(String[] args) {
        String s="applepenapple";
        List<String> wordList=new ArrayList<>();
        wordList.add("apple");
        wordList.add("pen");
        wordList.add("pen");
        for (String s1:wordList){
            System.out.println(s1);
        }
        System.out.println(wordBreak(s,wordList));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i]=dp[j] && set.contains(s.substring(j,i));
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
