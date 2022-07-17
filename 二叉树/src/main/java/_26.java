
/**
 * 剑指 Offer 26. 树的子结构//使用递归解
 */
public class _26 {
    public static void main(String[] args) {
        TreeNode treeA = utils.createTree();
        TreeNode treeB = utils.createTree();
        boolean subStructure = isSubStructure(treeA, treeB);
        System.out.println("是否为true:"+subStructure);
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        return  recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public static boolean recur(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val == B.val){
            return recur(A.left,B.left) && recur(A.right,B.right);
        }else {
            return false;
        }
    }
}
