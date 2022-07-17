import org.junit.Test;

public class aaaTest {
    @Test
    public void method(){
        int [] arr =new int[]{1,3,5,4,2};
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]){
                continue;
            }
            else {
                return;
            }
        }
    }
}
