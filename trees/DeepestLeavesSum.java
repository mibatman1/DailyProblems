package dailyproblems.trees;

public class DeepestLeavesSum 
{
    private int depth(TreeNode node)
    {
        if(node==null)
            return 0;
        int lh=depth(node.left);
        int rh=depth(node.right);
        return 1+Math.max(lh, rh);
    }

    public int deepestLeavesSum(TreeNode root) 
    {
        int depth=depth(root);
        return helper(root,depth);
    }

    private int helper(TreeNode node, int level)
    {
        if(node==null)
            return 0;
        if(level==1)
            return node.val;
        return helper(node.left, level-1)+helper(node.right, level-1);
    }

    public static void main(String[] args) {
        
    }
}
