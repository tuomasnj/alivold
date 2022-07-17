import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _728 {
    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        System.out.println(selfDividingNumbers(left, right));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static boolean isSelfDividing(int a) {
        int temp = a;
        while (temp > 0) {
            int data = temp % 10;
            if (data == 0 || a % data != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }
}
