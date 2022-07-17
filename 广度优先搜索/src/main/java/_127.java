import java.util.*;

public class _127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        int res = ladderLength(beginWord, endWord, wordList);
        System.out.println(res);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第1步：先将 wordList 放到哈希表里，便于判断某个单词是否在wordList里
        // 如果不存在这个endWord，直接返回0
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        //第2步：图的广度优先遍历，使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //第3步：开始广度优先遍历，包含起点，因此初始化的时候步数为1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();

                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            //图往下走了一步，可以理解为深度加1  所以step++
            step++;
        }
        //如果走不通，就返回0
        //可能在wordList中存在单词，但是并不能按照题目的要求实现单词接龙
        return 0;
    }

    private static boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] chars = currentWord.toCharArray();
        for (int i = 0; i < currentWord.length(); i++) {
            //标记初试字母，在每一轮循环阶数之后要把修改的字母复原
            char originLetter = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String myWord = String.valueOf(chars);
                if (myWord.equals(endWord)) {
                    return true;
                } else if (wordSet.contains(myWord) && !visited.contains(myWord)) {
                    queue.add(myWord);
                    visited.add(myWord);
                }
            }
            chars[i] = originLetter;
        }
        return false;
    }
}
