package dailyproblems.bst;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/?envType=problem-list-v2&envId=mmbknbs2
public class TwoSumIV 
{
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer>set=new HashSet<>();
        return solve(root, k, set);
    }

    private boolean solve(TreeNode node, int k, Set<Integer>set)
    {
        if(node==null)
            return false;
        int diff=k-node.val;
        if(set.contains(diff))
            return true;
        set.add(node.val);
        return solve(node.left, k, set) || solve(node.right, k, set);
    }
}
