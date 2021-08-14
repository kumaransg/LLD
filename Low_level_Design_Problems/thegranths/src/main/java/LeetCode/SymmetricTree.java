package LeetCode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(checkMirror(root.left,root.right)) return true;
        return false;
    }

    private boolean checkMirror(TreeNode node1, TreeNode node2){
        if(node1==null && node2 ==null) return true;
        if(node1 ==null || node2==null) return false;

        return (node1.val==node2.val)&&checkMirror(node1.left,node2.right)&&checkMirror(node1.right,node2.left);
    }
}
