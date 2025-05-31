package dailyproblems.bst;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/?envType=problem-list-v2&envId=mmbknbs2
public class ConstructBinaryTreeFromPreOrderTraversal 
{
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        var node=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++)
        {
            solve(node, preorder[i]);
        }
        return node;
    }

    private void solve(TreeNode node, int val)
    {
        if(val<node.val)
        {
            if(node.left==null)
            {
                node.left=new TreeNode(val);
            }
            else
            {
                solve(node.left, val);
            }
        }
        else if(val>node.val)
        {
            if(node.right==null)
            {
                node.right=new TreeNode(val);
            }
            else
            {
                solve(node.right, val);
            }
        }
    }
}
