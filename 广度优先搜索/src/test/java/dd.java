public class dd {
  public static void main(String[] args) {
    int[] res = primeFactor(100);
    for (int i : res) {
      System.out.print(i + " ");
    }
  }
   //整数包含的质数因子
  public static int[] primeFactor(int n) {
    int[] res = new int[n];
    int index = 0;
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        res[index++] = i;
        n /= i;
      }
    }
    return subArray(res, 0, index - 1);
  }
  //截取数组
  public static int[] subArray(int[] arr, int start, int end) {
    int[] res = new int[end - start + 1];
    for (int i = start; i <= end; i++) {
      res[i - start] = arr[i];
    }
    return res;
  }
}

