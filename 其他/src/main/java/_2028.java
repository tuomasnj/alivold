import java.util.Arrays;

public class _2028 {
    public static void main(String[] args) {
        int []rolls={2,3,5,5,4,1};
        int mean=2,n=6;
        int[] ans = missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int rollsSum = 0;
        for (int i = 0; i < rolls.length; i++) {
            rollsSum += rolls[i];
        }
        int ActSum = mean * (rolls.length + n);
        int leftVal = ActSum - rollsSum;
        if(leftVal > 6 * n || leftVal < n)return new int[]{};
        else {
            int[] ret = new int[n];
            int singVal = leftVal/n;
            Arrays.fill(ret, singVal);
            int nowTotalVal = singVal*n,sub=leftVal - nowTotalVal;
            if(sub == 0)return ret;
            int unit = sub/Math.abs(sub);
            System.out.println(sub);
            int i=0,times=0;
            boolean flag=true;
            while (i < ret.length && flag) {
                while (1 <= ret[i]&& ret[i] < 6 && sub>0){
                    if(times == Math.abs(sub)){
                        flag=false;
                        break;
                    }
                    ret[i] += unit;
                    times++;
                }
                while (1 < ret[i]&& ret[i] <= 6 && sub<0){
                    if(times == Math.abs(sub)){
                        flag=false;
                        break;
                    }
                    ret[i] += unit;
                    times++;
                }
                i++;
            }
            return ret;
        }
    }
}
