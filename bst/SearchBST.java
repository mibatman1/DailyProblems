package dailyproblems.bst;

// https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=problem-list-v2&envId=mmbknbs2
public class SearchBST 
{
    public TreeNode searchBST(TreeNode root, int val) {
        return solve(root, val);
    }

    private TreeNode solve(TreeNode node, int val)
    {
        if(node==null)
            return null;
        if(node.val==val)
            return node;
        if(node.val<val)
            return solve(node.right, val);
        return solve(node.left, val);
    }
}
