package dailyproblems.bst;

// https://leetcode.com/problems/trim-a-binary-search-tree/description/?envType=problem-list-v2&envId=mmbknbs2
public class TrimABinarySearchTree 
{
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return solve(root, low, high);
    }

    private TreeNode solve(TreeNode node, int low, int high)
    {
        if(node==null)
            return null;
        if(node.val>=low && node.val<=high)
        {
            node.left=solve(node.left, low, high);
            node.right=solve(node.right, low, high);
        }
        else if(node.val<low)
        {
            node=solve(node.right, low, high);
        }
        else if(node.val>high)
        {
            node=solve(node.left, low, high);
        }
        return node;
    }
}
