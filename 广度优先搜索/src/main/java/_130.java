import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _130 {
    public static void main(String[] args) {
        char[][] board={{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("=============================");
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public static void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;;
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        Queue<int[]> queue=new LinkedList();
        for (int i = 0; i < m; i++) {
            if(board[i][0] == 'O'){
                board[i][0]='A';
                queue.offer(new int[]{i,0});
            }
            if(board[i][n-1] == 'O'){
                board[i][n-1]='A';
                queue.offer(new int[]{i,n-1});
            }
        }

        for (int j = 1; j < n-1; j++) {
            if(board[0][j] == 'O'){
                board[0][j]='A';
                queue.offer(new int[]{0,j});
            }if(board[m-1][j] == 'O'){
                board[m-1][j]='A';
                queue.offer(new int[]{m-1,j});
            }
        }
        
        while (!queue.isEmpty()){
            int[] position = queue.poll();
            for (int i = 0; i < 4; i++) { 
                int x=position[0]+dx[i];
                int y=position[1]+dy[i];
                if((x>=0 && x<=m-1) && (y>=0 && y<=n-1) && board[x][y]=='O'){
                    board[x][y]='A';
                    queue.offer(new int[]{x,y});
                }else {
                    continue;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }
}
