public class _27 {
    static TreeNode treeNode;
    public static void main(String[] args) {
        TreeNode tree = utils.createTree();
        System.out.println(mirrorTree(tree));
    }
    public static TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right= mirrorTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
