public class CountSubStrings {
    public static void main(String[] args) {
        String s = "aaa";
        int numCount = countSubStrings(s);
        System.out.println(numCount);
    }
    public static int countSubStrings(String s){
        int res = 0;
        int len = s.length();
        for (int i = 0; i <= 2 * len - 2; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while (left >= 0 && right < len){
                if(s.charAt(left) == s.charAt(right)){
                    res ++;
                    left --;
                    right ++;
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
