public class _693 {
    public static void main(String[] args) {
        int num= 11;
        boolean ans = hasAlternatingBits(num);
        System.out.println(ans);
    }
    public static boolean hasAlternatingBits(int n) {
        return judge(n>>1,n&1);
    }
    public static boolean judge(int n, int pre){
        boolean flag = false;
        if(n==0)return true;
        int cur= n & 1;
        if(cur != pre){
            flag=judge(n >>1,cur);
        }
        return false || flag;
    }
}
