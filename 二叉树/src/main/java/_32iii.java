import java.util.*;

/*
    剑指Offer32-III.从上到下打印二叉树III
 */
public class _32iii {
    public static void main(String[] args) {
        TreeNode treeNode = utils.createTree();
        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    temp.add(cur.val);
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if (temp.size() > 0) {
                if (depth % 2 == 1) {
                    list.add(temp);
                }
                else {
                    Collections.reverse(temp);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
