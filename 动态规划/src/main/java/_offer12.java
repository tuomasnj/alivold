public class _offer12 {
    public static void main(String[] args) {
        char[][] board = {{'A','B'}, {'C','D'}};
        System.out.println(exist(board, "ABCD"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word.toCharArray(), i, j, 0, visited)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int k, boolean[][] v) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || v[i][j] || board[i][j]!=word[k])
            return false;
        if (k == word.length) return true;
        v[i][j] = true;
        boolean res = (dfs(board, word, i + 1, j, k + 1, v) || dfs(board, word, i, j + 1, k + 1, v) || dfs(board, word, i - 1, j, k + 1, v)
                || dfs(board, word, i, j - 1, k + 1, v));
        v[i][j] = false;
        return res;
    }
}
