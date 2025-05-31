package dailyproblems.binarytree;

// https://leetcode.com/problems/binary-tree-tilt/?envType=problem-list-v2&envId=mmbknbs2
public class BinaryTreeTilt 
{
    private int sum=0;

    public int findTilt(TreeNode root) {
        solve(root);
        return sum;
    }
    
    private int solve(TreeNode node)
    {
        if(node==null)
            return 0;
        int l=solve(node.left);
        int r=solve(node.right);
        sum+=Math.abs(l-r);
        return node.val+l+r;
    }
}
