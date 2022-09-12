import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class MyTest {
    @Test
    public void testString() {
        String s = "1.";
        // System.out.println("这是parseInt方法==="+Integer.parseInt(s)+"===");
        // System.out.println("这是valueOf方法==="+Integer.valueOf(s)+"==="+Integer.valueOf(s).getClass());

        String[] split = s.split("\\.");
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void testSuShu() {
        System.out.println("输出100-200之间所有的素数:");
        long beg = System.currentTimeMillis();
        int n = 100;
        while (n <= 200) {
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0) {
                    break;
                }
                if(i == Math.floor(Math.sqrt(n))){
                    System.out.print(n + "--");
                }
            }
            n++;
        }
        long end = System.currentTimeMillis();
        System.out.println();
        long time = end - beg;
        System.out.println("用时" + time);
    }
}
