import org.junit.Test;

import java.util.Arrays;

public class MyTest {
    @Test
    public  void testString(){
        String s="1.";
       // System.out.println("这是parseInt方法==="+Integer.parseInt(s)+"===");
       // System.out.println("这是valueOf方法==="+Integer.valueOf(s)+"==="+Integer.valueOf(s).getClass());

        String[] split = s.split("\\.");
        System.out.println(Arrays.toString(split));
    }
}
