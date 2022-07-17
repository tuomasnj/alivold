import org.junit.Test;

public class Mytest {
    @Test
    public void test01(){
        for (char i = 'a'; i < 'z'; i++) {
            System.out.println(i);
            System.out.println(i+1);
            System.out.println(i-'a');
        }
        System.out.println("==================");
        char kk='a';
        kk++;
        System.out.println(kk);
    }
}
