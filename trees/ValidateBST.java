package dailyproblems.trees;

// https://leetcode.com/problems/validate-binary-search-tree/?envType=problem-list-v2&envId=m22zk1nr
public class ValidateBST 
{
    private int min=Integer.MIN_VALUE;
    private int max=Integer.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        return solve(root, min, max);
    }

    boolean solve(TreeNode node, int min, int max)
    {
        if(node==null)
        {
            return true;
        }
        if(node.val<=min || node.val>=min)
            return true;
        return solve(node, min, node.val) && solve(node, node.val, max);
    }
}
