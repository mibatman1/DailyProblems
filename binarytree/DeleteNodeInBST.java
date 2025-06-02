package dailyproblems.binarytree;

public class DeleteNodeInBST 
{
    public TreeNode deleteNode(TreeNode root, int key) 
    {
        if(root==null)
            return null;
        if(root.val<key)
        {
            root.right=deleteNode(root.right, key);
        }
        else if(root.val>key)
        {
            root.left=deleteNode(root.left, key);
        }
        else
        {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            else
            {
                root.val=minValue(root.right);
                root.right=deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private int minValue(TreeNode node)
    {
        var minValue=node.val;
        while(node.left!=null)
        {
            minValue=node.left.val;
            node=node.left;
        }
        return minValue;
    }
}
