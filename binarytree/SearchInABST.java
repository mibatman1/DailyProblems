package dailyproblems.binarytree;

public class SearchInABST 
{
    public TreeNode searchBST(TreeNode root, int val) 
    {
        return solve(root, val);
    }

    private TreeNode solve(TreeNode node, int val)
    {
        if(node==null)
            return null;
        if(node.val==val)
            return node;
        else if(val<node.val)
            return solve(node.left, val);
        return solve(node.right,val);
    }
}
