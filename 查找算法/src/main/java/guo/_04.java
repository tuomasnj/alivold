package guo;

public class _04 {
    public static void main(String[] args) {
        int [][]arr=new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = findNumberIn2DArray(arr, 20);
        System.out.println(numberIn2DArray);
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int width=matrix[0].length-1;
        int height=0;
        while (height<= matrix.length-1 && width >=0){
            if(height<= matrix.length-1 && width >=0 && matrix[height][width] < target){
                height++;
            }
            if(height<= matrix.length-1 && width >=0 && matrix[height][width] > target){
                width--;
            }
            if(height<= matrix.length-1 && width >=0 && matrix[height][width] == target)
            {
                return true;
            }
        }
        return false;
    }
}
