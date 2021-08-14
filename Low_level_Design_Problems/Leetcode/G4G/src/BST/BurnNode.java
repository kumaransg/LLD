package BST;

import java.util.HashMap;
import java.util.List;

public class BurnNode {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    HashMap<TreeNode,Integer> hm = new HashMap<>();
    int max=0;
    //int max2=0;

    int find(TreeNode root,TreeNode target){
        if(root==null)
            return -1;
        if(root.val==target.val){
            hm.put(root,0);
            return 0;
        }
        int left = find(root.left,target);
        if(left>=0){
            hm.put(root,left+1);
            return left+1;
        }
        int right = find(root.right,target);
        if(right>=0){
            hm.put(root,right+1);
            return right+1;
        }
        return -1;
    }

    int traverse(TreeNode root, TreeNode target, int time){
        if(root==null){
            return 0;
        }
        if(hm.containsKey(root))
        {
            time = hm.get(root);
        }

        int left = traverse(root.left, target, time+1);
        int right = traverse(root.right, target, time+1);
        if(root==target){
            //max = Math.max(left,right);
            return 1;
        }
        max=Math.max(right+left,max);
        return Math.max(left+1,right+1);
    }

    public int distanceK(TreeNode root, TreeNode target) {
        if(root==null)
            return 0;
        find(root,target);
        int answer = traverse(root, target, 0);
        //addNodes(root,target,K,hm.get(root));
        return answer;
    }

    public static void main(String args[]){
        BurnNode bn = new BurnNode();
        TreeNode root = new TreeNode(3);
        TreeNode five  = new TreeNode(5);
        TreeNode one  = new TreeNode(1);
        TreeNode zero  = new TreeNode(0);
        TreeNode eight  = new TreeNode(8);
        TreeNode two  = new TreeNode(2);
        TreeNode six  = new TreeNode(6);
        TreeNode seven  = new TreeNode(7);
        TreeNode four  = new TreeNode(4);

        root.right=one;
        root.left=five;
        one.right=eight;
        one.left=zero;
        five.left=six;
        five.right=two;
        two.left=seven;
        two.right=four;
        int ans = bn.distanceK(root,six);
        System.out.println(ans);
        System.out.println(bn.max+" seconds");
        //System.out.println(bn.max2);
    }
}
