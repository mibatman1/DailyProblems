package dailyproblems.binarytree;

public class LCAOfDeepestNode 
{
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth=getMaxDepth(root);
        return solve(root, maxDepth, 0);
    }
    
    private TreeNode solve(TreeNode node, int maxDepth, int s)
    {
        if(node==null)
            return null;
        if(maxDepth-1==s)
            return node;
        var left=solve(node.left, maxDepth, s+1);
        var right=solve(node.right, maxDepth, s+1);
        if(left!=null)
            return right;
        if(right!=null)
            return left;
        return node;
    }

    private int getMaxDepth(TreeNode node)
    {
        if(node==null)
            return 0;
        return 1+Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }
}
