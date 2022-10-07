package guo;

public class Main {
    public static void main(String[] args) {
        int num = 123654;
        int num1 = num;
        int res = 0;
        int index = 0;
        while (num > 0){
            index++;
            num /= 10;
        }
        while (num1 > 0){
            res += num1 % 10 * Math.pow(10, index - 1);
            index --;
            num1 /= 10;
        }
        System.out.println(res);
    }
}
