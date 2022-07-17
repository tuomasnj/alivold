import java.util.Arrays;

public class _1744 {
    public static void main(String[] args) {
        int[] candiesCount = {5, 2, 6, 4, 1};
        int[][] queries = {{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}};
        System.out.println(Arrays.toString(canEat(candiesCount, queries)));
    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int num = queries.length;
        boolean[] bool = new boolean[num];
        for (int i = 0; i < num; i++) {
            int preDay = queries[i][1];
            int minCandy = preDay * 1;
            int maxCandy = preDay * queries[i][2];
            int candyAmountMin = 0;
            for (int j = 0; j < queries[i][0]; j++) {
                candyAmountMin += candiesCount[j];
            }
            int candyAmountMax = candyAmountMin + candiesCount[queries[i][0]];
            if(maxCandy+queries[i][2] <= candyAmountMin ){
                bool[i]=false;
                continue;
            }
            if(minCandy>=candyAmountMax){
                bool[i]=false;
                continue;
            }
            bool[i]=true;
        }
        return bool;
    }
}
