import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _452 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int length=scanner.nextInt();
        int[][] arr=new int[length][2];
        int time=0;
        while (time<length){
            arr[time][0]=scanner.nextInt();
            arr[time][1]=scanner.nextInt();
            time++;
        }
        int minArrowShots = findMinArrowShots(arr);
        System.out.println(minArrowShots);
    }
    public static int findMinArrowShots(int[][] points){
        if(points[0][1]== 2147483647)return 2;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int arrowNum=1;
        int pre=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] <= pre){
                continue;
            }else {
                pre=points[i][1];
                arrowNum++;
            }
        }
        System.out.println(2147483646<-2147483645);
        return arrowNum;
    }
}
