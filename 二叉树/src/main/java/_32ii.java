import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    剑指Offer32-II.从上到下打印二叉树II
 */
public class _32ii {
    public static void main(String[] args) {
        TreeNode treeNode = utils.createTree();
        List<List<Integer>> list = levelOrder(treeNode);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
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
                list.add(temp);
            }
        }
        return list;
    }
}
