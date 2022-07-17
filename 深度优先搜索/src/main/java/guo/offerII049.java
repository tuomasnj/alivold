package guo;

import java.util.ArrayList;
import java.util.List;

public class offerII049 {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode tree = utils.createTree();
        System.out.println(sumNumbers(tree));
    }

    public static int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        int res = 0;
        for (Integer i : list) {
            res += i;
        }
        return res;
    }

    public static void dfs(TreeNode node, StringBuilder temp) {
        if (node == null) {
            return;
        }
        temp = temp.append(node.val);
        dfs(node.left, temp);
        dfs(node.right, temp);
        if (node.left == null && node.right == null) {
            list.add(Integer.parseInt(temp.toString()));
        }
        temp.deleteCharAt(temp.length()-1);//在当前层结束时，删除该层的节点。在退回上一层之前进行处理。
    }
}
