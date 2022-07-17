package guo;

public class offerII116 {
    /**
     * 省份数量
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == false) {
                isVisited[i]=true;
                dfs(i,isVisited,isConnected);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int cityNum, boolean[] b, int[][] isConnected){
        int[] num = isConnected[cityNum];
        int len =num.length;
        for (int i = 0; i < len; i++) {
            if(num[i] == 1 && b[i]==false){
                b[i] = true;
                dfs(i,b,isConnected);
            }
        }
    }
}
