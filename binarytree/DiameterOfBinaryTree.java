package dailyproblems.binarytree;

public class DiameterOfBinaryTree 
{
    public int diameterOfBinaryTree(TreeNode root) {
        int max[]=new int[1];
        solve(root, max);
        return max[0];
        
    }

    private int solve(TreeNode node, int maxi[])
    {
        if(node==null)
            return 0;
        int l=solve(node.left, maxi);
        int r=solve(node.right, maxi);
        maxi[0]=Math.max(maxi[0], l+r);
        return 1+Math.max(l,r);
    }
}
