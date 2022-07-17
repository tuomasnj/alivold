package guo;
public class SameTree {
    static boolean flag =true;
    public static void main(String[] args) {
        System.out.println("输入第一个树");
        TreeNode tree1=utils.createTree();
        System.out.println("输入第二个树");
        TreeNode tree2=utils.createTree();
        boolean sameTree = isSameTree(tree1, tree2);
        System.out.println(sameTree);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(flag==false){
            return false;
        }
        if(p==null &&q==null){
            return true;
        }
        else if(p!=null&&q!=null&&p.val==q.val){
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);
        }
        else {
            flag=false;
        }
        return flag;
    }
}
