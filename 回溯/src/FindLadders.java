import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindLadders {
    public static void main(String[] args) {
        String beg = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dog", "dot", "log", "lot", "cog");
        System.out.println(findLadders(beg, end, wordList));
    }

    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> set = new HashSet<>(wordList);
        List<String> trans = new ArrayList<>();
        trans.add(beginWord);
        visited.add(beginWord);
        if (dfs(endWord, beginWord.toCharArray(), set, visited, trans)) {
            return trans;
        }
        return new ArrayList<>();
    }

    public static boolean dfs(String endWord, char[] word, HashSet<String> set, HashSet<String> visit, List<String> trans) {
        if (new String(word).equals(endWord)) {
            return true;
        }
        for (int i = 0; i < word.length; i++) {
            char ch = word[i];
            for (char j = 'a'; j < 'z'; j++) {
                word[i] = j;
                if (set.contains(new String(word)) && !visit.contains(new String(word))) {
                    trans.add(new String(word));
                    visit.add(new String(word));
                    if(dfs(endWord, new String(word).toCharArray(), set, visit, trans)){
                        return true;
                    }
                    trans.remove(trans.size() - 1);
                }
            }
            word[i] = ch;
        }
        return false;
    }
}
