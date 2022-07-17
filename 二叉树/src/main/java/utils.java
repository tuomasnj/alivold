import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class utils {
    static TreeNode node;
    public static TreeNode createTree() {
        Queue<TreeNode> queue = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int layer = sc.nextInt();
        int index = 0;
        while (index < layer) {
            if (queue.isEmpty()) {
                node = new TreeNode(sc.nextInt());
                queue.add(node);
            } else {
                while (!queue.isEmpty() && queue.size()<Math.pow(2,layer-1)) {
                    TreeNode treeNode = queue.poll();
                    treeNode.left = new TreeNode(sc.nextInt());
                    treeNode.right = new TreeNode(sc.nextInt());
                    queue.add(treeNode.left);
                    queue.add(treeNode.right);
                }
            }
            ++index;
        }
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
