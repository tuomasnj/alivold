import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(Arrays.toString(list.toArray(new Integer[]{})));
    }
}
