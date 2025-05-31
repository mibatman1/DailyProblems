package dailyproblems.bst;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/?envType=problem-list-v2&envId=mmbknbs2
public class InsertIntoBST 
{
    public TreeNode insertIntoBST(TreeNode root, int val) 
    {
        if(root==null)
            return new TreeNode(val);
        if(root.val>val)
            root.left=insertIntoBST(root.left, val);
        else
            root.right=insertIntoBST(root.right, val);
        return root;   
    }
}
