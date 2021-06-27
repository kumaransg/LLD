package LeetCode;

public class BinaryTreeMaximumSumPath {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans = Math.max(ans,root.val+leftSum+rightSum);
        return Math.max(0,root.val+ Math.max(leftSum,rightSum));
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

}
