import java.util.*;

public class _offer2_033 {
    //变位词组
    public static void main(String[] args) {
        String[] strs= new String[6];
        strs[0] = "eat";
        strs[1] = "tea";
        strs[2] = "tan";
        strs[3] = "ate";
        strs[4] = "nat";
        strs[5] = "bat";
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list:lists){
            System.out.print(list+" ");
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();

        for(int i =0;i< strs.length;i++){
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String key = String.valueOf(a);
            if(!map.containsKey(key)){
                ArrayList<String> lis= new ArrayList<>();
                lis.add(strs[i]);
                map.put(key,lis);
            }else {
                List<String> lis = map.get(key);
                lis.add(strs[i]);
                map.put(key,lis);
            }
        }
        Collection<List<String>> values = map.values();
        return new ArrayList<>(values);
    }
}
