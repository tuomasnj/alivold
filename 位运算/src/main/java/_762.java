public class _762 {
    public static void main(String[] args) {
        //System.out.println(countPrimeSetBits(6, 10));
        System.out.println(isPrime(2));
    }

    public static int countPrimeSetBits(int left, int right) {
        int res=0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            int opr = i;
            while (opr != 0) {
                count += (opr & 1);
                opr = opr >> 1;
            }
            res+= isPrime(count)?1:0;
        }
        return res;
    }

    public static boolean isPrime(int n) {
        if(n == 1)return false;
        int num = 2;
        int sqrtN=(int)Math.sqrt(n);
        while (num < sqrtN + 1) {
            if (n % num != 0)
                num++;
            else return false;
        }
        return true;
    }
}
