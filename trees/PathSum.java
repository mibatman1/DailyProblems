package dailyproblems.trees;

public class PathSum 
{
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(solve(root, targetSum, 0))
            return true;
        return false;
    }

    boolean solve(TreeNode node, int tSum, int currSum)
    {
        if(node==null)
            return false;
        if(node.left==null && node.right==null)
        {
            if(currSum+node.val==tSum)
                return true;
            return false;
        }
        return solve(node.left, tSum, currSum+node.val) || solve(node.right, tSum, currSum+node.val);
    }
}
