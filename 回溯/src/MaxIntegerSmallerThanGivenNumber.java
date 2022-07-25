import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxIntegerSmallerThanGivenNumber {

    public static void main(String[] args) {
        int num = 4568;
        int[] arr =new int[]{3,4,5,1};
        System.out.println(calculate(num, arr));
    }
    public static int calculate(int num, int[] arr){
        boolean[] used = new boolean[arr.length];
        List<Integer> res = arrange(num, arr, used);
        Collections.sort(res, (a1, a2) -> a2 - a1);
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i) < num){
                return res.get(i);
            }
        }
        return 0;
    }
    public static List<Integer> arrange(int num, int[] arr, boolean[] used){
        ArrayList<Integer> arrayList = new ArrayList<>();
        help(String.valueOf(num), arr, arrayList, new StringBuilder(), used);
        return arrayList;
    }
    public static void help(String num, int[] arr, List<Integer> res, StringBuilder temp, boolean[] used){
        if(num.length() == temp.length()){
            res.add(Integer.parseInt(new String(temp)));
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            if(used[i]){
                continue;
            }
            temp.append(arr[i]);
            used[i] = true;
            help(num, arr, res, temp, used);
            temp.deleteCharAt(temp.length() - 1);
            used[i] = false;
        }
    }
}
