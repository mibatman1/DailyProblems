package dailyproblems.trees;

public class BalancedBinaryTree 
{
    public int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh=depth(root.left);
        int rh=depth(root.right);
        if(lh==-1 || rh==-1)
            return -1;
        if(Math.abs(lh-rh)>1)
            return -1;
        return 1+Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) 
    {
        return depth(root)!=-1;
    }

    public static void main(String[] args) {
        
    }
}
