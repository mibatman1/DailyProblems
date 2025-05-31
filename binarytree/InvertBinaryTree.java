package dailyproblems.binarytree;

// https://leetcode.com/problems/invert-binary-tree/description/?envType=problem-list-v2&envId=mmbknbs2
public class InvertBinaryTree 
{
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }
    
    private void solve(TreeNode node)
    {
        if(node==null)
            return;
        var temp=node.left;
        node.left=node.right;
        node.right=temp;

        solve(node.left);
        solve(node.right);
    }
}
