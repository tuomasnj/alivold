import java.util.*;

public class Main2 {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmpKey = sc.nextInt();
            int tmpValue = sc.nextInt();
            if(!map.containsKey(tmpKey)){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(tmpValue);
                map.put(tmpKey, arr);
            }else{
                List<Integer> arr = map.get(tmpKey);
                arr.add(tmpValue);
            }
        }
        res = 0;
        HashSet<Integer> hs = new HashSet<>();
        bfs(map, c, hs);
        System.out.println(res);
    }

    private static void bfs(HashMap<Integer, List<Integer>> map, int c, HashSet<Integer> hs) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(c);
        while (!queue.isEmpty()){
            Integer key = queue.poll();
            if(!hs.contains(key)){
                res ++;
            }
            if(!map.containsKey(key) || hs.contains(key)){
                continue;
            }
            hs.add(key);
            for (Integer integer: map.get(key)) {
                queue.add(integer);
            }
        }
    }
}
