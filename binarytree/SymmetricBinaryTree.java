package dailyproblems.binarytree;

// https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricBinaryTree 
{
    public boolean isSymmetric(TreeNode root) {
        return root==null || solve(root.left, root.right);
    }
    
    private boolean solve(TreeNode left, TreeNode right)
    {
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return solve(left.left, right.right) && solve(left.right, right.left);
    }
}
