public class CheckSubTree {
    public static void main(String[] args) {
        TreeNode t1 = utils.createTree();
        TreeNode t2 = utils.createTree();
        boolean res = checkSubTree(t1, t2);
        System.out.println(res);
    }

    public static boolean checkSubTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null){
            return true;
        }
        else if (node1 == null || node2 == null){
            return false;
        }
        if(node1.val == node2.val){
            return checkSubTree(node1.left,node2.left) && checkSubTree(node1.right,node2.right);
        }
        return checkSubTree(node1.left,node2) || checkSubTree(node1.right,node2);
    }
}
