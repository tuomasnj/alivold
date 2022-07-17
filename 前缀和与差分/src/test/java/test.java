import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int [][] a=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        test test = new test();
        int[] ints = test.spiralOrder(a);
        System.out.println(Arrays.toString(ints));
    }
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int a=matrix.length;
        int b =matrix[0].length;
        int total= 0;
        int [] result=new int[a*b];
        System.out.println(result.length);
        int border=0;
        while(total<a*b){
            int x=border,y=border;
            while (y==border && x<=b-1-border){
                if (total==a*b)break;
                result[total]=matrix[y][x];
                total++;
                x++;
            }x--;y++;
            while (x==b-1-border && border<y && y<=a-1-border){
                if (total==a*b)break;
                result[total]=matrix[y][x];
                total++;
                y++;
            }y--;x--;
            while (y==a-1-border && x>=border &&x<b-1-border){
                if (total==a*b)break;
                result[total]=matrix[y][x];
                total++;
                x--;
            }x++;y--;
            while (x==border && y>border &&y<a-1-border){
                if (total==a*b)break;
                result[total]=matrix[y][x];
                total++;
                y--;
            }y++;x++;
            border++;
        }
        return result;
    }
}
