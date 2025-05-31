package dailyproblems.trees;

public class LCA 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root)
            return root;
        var left=lowestCommonAncestor(root.left, p, q);
        var right=lowestCommonAncestor(root.right, p, q);
        
        if(left==null)
            return right;
        if(right==null)
            return left;
        else
            return root;
    }
}
