package dailyproblems.bst;

public class IsSubTree 
{
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        if(solve(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean solve(TreeNode node, TreeNode subRoot)
    {
        if(node==null && subRoot==null)
            return true;
        if(node==null || subRoot==null && node.val!=subRoot.val)
            return false;
        return solve(node.left, subRoot.left) && solve(node.right, subRoot.right);
    }
}
