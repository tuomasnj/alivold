import java.util.ArrayList;
import java.util.List;

public class offerii_052 {
    public static void main(String[] args) {
        TreeNode tree =new TreeNode(3);
        tree.left=new TreeNode(1);
        TreeNode treeNode = increasingBST(tree);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode();
        TreeNode origin = res;
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        dfs(root, treeNodes);
        for(TreeNode node: treeNodes){
            res.right=node;
            res = res.right;
            res.left = null;
            res.right = null;
        }
        return origin.right;
    }

    public static List dfs(TreeNode node, List res) {
        if (node == null) {
            return null;
        }
        dfs(node.left, res);
        res.add(node);
        dfs(node.right, res);
        return res;
    }
}
