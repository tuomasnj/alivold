package guo;

public class NumRookCaptures {
    static int num = 0;
    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {
                '.', '.', '.', 'p', '.', '.', '.', '.'}, {'p', 'p', '.', 'R', '.', 'p', 'B', '.'}, {
                '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'B', '.', '.', '.', '.'}, {
                '.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(numRookCaptures(board));
    }

    public static int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            dfs(x, y, board, i);
        }
        return num;
    }

    public static void dfs(int x, int y, char[][] board, int dir) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] == 'B') {
            return;
        } else if (board[x][y] == 'p') {
            num++;
            return;
        }
        switch (dir) {
            case 0:
                dfs(x + 1, y, board, 0);
                break;
            case 1:
                dfs(x - 1, y, board, 1);
                break;
            case 2:
                dfs(x, y + 1, board, 2);
                break;
            case 3:
                dfs(x, y - 1, board, 3);
                break;
        }
    }
}
