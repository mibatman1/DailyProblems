package dailyproblems.trees;

public class SumRootToLeafNumber {

    public int sumNumbers(TreeNode root) {
        return solve(root, 0);
    }

    int solve(TreeNode node, int sum)
    {
        if(node==null)
            return 0;
        sum=sum*10+node.val;
        if(node.left==null && node.right==null)
            return sum;
        return solve(node.left, sum)+solve(node.right, sum);
    }
}
