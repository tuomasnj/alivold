import java.util.*;

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] res = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map =new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = 0;
            while (count < map.get(arr2[i])){
                res[index] = arr2[i];
                count ++;
                index ++;
            }
            map.remove(res[index - 1]);
        }
        ArrayList<Integer> tail = new ArrayList<>();
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            for (int i = 0; i < map.get(key); i++) {
                tail.add(key);
            }
        }
        Collections.sort(tail);
        int refer = 0;
        while (index < arr1.length){
            res[index] = tail.get(refer);
            index ++;
            refer ++;
        }
        return res;
    }
}
