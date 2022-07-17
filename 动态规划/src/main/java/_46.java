public class _46 {
    public static void main(String[] args) {
        int num=506;
        int count=translateNum(num);
        System.out.println(count);
    }
    public static int translateNum(int num) {
        int length=String.valueOf(num).length();
        String string=String.valueOf(num);
        int[] dp=new int[length+1];
        dp[0]=1;
        for (int i = 1; i <=length ; i++) {
            if(i-2>=0 && Integer.parseInt(string.substring(i-2,i))<=25
                    && Integer.parseInt(string.substring(i-2,i-1))!=0){
                dp[i]=dp[i-2]+dp[i-1];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[length];
    }
}
