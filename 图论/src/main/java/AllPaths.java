import java.util.LinkedList;
import java.util.List;

public class AllPaths {
    static List<List<Integer>> res = new LinkedList();

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<Integer>();
        traverse(graph, 0, path);
        return res;
    }

    public static void traverse(int[][] graph, int i, LinkedList<Integer> path) {
        path.addLast(i);
        if (i == graph.length - 1) {
            res.add(new LinkedList<Integer>(path));
            path.removeLast();
            return;
        }
        for (int a : graph[i]) {
            traverse(graph, a, path);
        }
        path.removeLast();
    }
}
