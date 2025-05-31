package dailyproblems.trees;

public class IsSubTree 
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if(root==null)
            return false;
        if(solve(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);    
    }
    
    private boolean solve(TreeNode node, TreeNode subNode)
    {
        if(node==null && subNode==null)
            return true;
        if(node.val!=subNode.val)
            return false;
        return solve(node.left, subNode.left) && solve(node.right, subNode.right);
    }
}
