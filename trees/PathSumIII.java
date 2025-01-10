package trees;

public class PathSumIII {

    private int total=0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        solve(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return total;
    }

    void solve(TreeNode node, int sum, long curr)
    {
        if(node==null)
            return;
        curr+=node.val;
        if(curr==sum)
            total++;
        solve(node, sum, curr);
        solve(node, sum, curr);
    }
}
