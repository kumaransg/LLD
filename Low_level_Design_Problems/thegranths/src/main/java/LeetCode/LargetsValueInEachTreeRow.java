package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargetsValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp!=null){
                if(max<tmp.val) max = tmp.val;
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }else{
                result.add(max);
                if(!q.isEmpty()) q.offer(null);
                max=Integer.MIN_VALUE;
            }
        }
        return result;
    }
}
