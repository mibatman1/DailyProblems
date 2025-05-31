package dailyproblems.binarytree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestorOfBinaryTree 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        var left=lowestCommonAncestor(root.left, p, q);
        var right=lowestCommonAncestor(root.right, p, q);
        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;
    }
}
