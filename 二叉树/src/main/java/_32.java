import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _32 {
    public static void main(String[] args) {
        TreeNode tree = utils.createTree();
        int[] ints = levelOrder(tree);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] levelOrder(TreeNode root) {
        int index = 0;
        int[] arr = new int[1000];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root=queue.poll();
            if (root != null) {
                arr[index] = root.val;
                queue.offer(root.left);
                queue.add(root.right);
                ++index;
            }
        }
        int[] res = new int[index];
        System.arraycopy(arr, 0, res, 0, index);
        return res;
    }
}
