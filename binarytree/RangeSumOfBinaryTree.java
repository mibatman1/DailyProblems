package dailyproblems.binarytree;

public class RangeSumOfBinaryTree 
{
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        solve(root, low, high);
        return sum;
    }
    
    private void solve(TreeNode node, int low, int high)
    {
        if(node==null)
            return;
        if(node.val>=low && node.val<=high)
        {
            sum+=node.val;
        }
        solve(node.left, low, high);
        solve(node.right, low, high);
    }
}
