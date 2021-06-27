package LeetCode;

public class PathSumBinaryTree {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left == null && root.right==null){
            return (sum==root.val);
        }
        int tmp = sum-root.val;

        return hasPathSum(root.left,tmp) || hasPathSum(root.right,tmp);

    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}