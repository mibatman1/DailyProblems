package dailyproblems.binarytree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIV 
{
    public boolean findTarget(TreeNode root, int k) 
    {
        Set<Integer>st=new HashSet<>();
        return solve(root, k, st);
    }

    private boolean solve(TreeNode node, int target, Set<Integer>st)
    {
        if(node==null)
            return false;
        int diff=target-node.val;
        if(st.contains(diff))
            return true;
        st.add(node.val);
        return solve(node.left, target, st) || solve(node.right, target, st);
    }
}
