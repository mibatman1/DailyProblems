package dailyproblems.trees;

// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/?envType=problem-list-v2&envId=depth-first-search
public class EvaluateBinaryBooleanTree {
    public boolean evaluateTree(TreeNode root) {
        return solve(root);
    }

    boolean solve(TreeNode node)
    {
        if(node==null)
            return false;
        if(node.val==2)
            return solve(node.left) || solve(node.right);
        else if(node.val==3)
            return solve(node.left) && solve(node.right);
        return false;
    }
}
