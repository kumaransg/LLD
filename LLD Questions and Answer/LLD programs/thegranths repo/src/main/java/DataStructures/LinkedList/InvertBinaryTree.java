package DataStructures.LinkedList;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmpNode = new TreeNode(root.val);
        tmpNode.left= invertTree(root.right);
        tmpNode.right= invertTree(root.left);
        return tmpNode;
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