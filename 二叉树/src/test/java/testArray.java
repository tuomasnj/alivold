import org.junit.Test;

import java.util.Arrays;

public class testArray {
    @Test
    public void copyArray(){
        int[] a1={1,2,3};
        int [] ints=new int[3];
        System.arraycopy(a1,1,ints,1,0);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void testCopyTreeNode(){
        TreeNode originNode =utils.createTree();
        TreeNode copyNode = copyTreeNode(originNode);
        int a=0;
    }

    public TreeNode copyTreeNode(TreeNode root) {
        TreeNode copyTree = null;
        if (root != null) {
            copyTree = new TreeNode (root.val);
            copyTree.left = copyTreeNode(root.left);
            copyTree.right = copyTreeNode(root.right);
        }
        return copyTree;
    }
}
