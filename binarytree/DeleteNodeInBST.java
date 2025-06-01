package dailyproblems.binarytree;

public class DeleteNodeInBST 
{
    public TreeNode deleteNode(TreeNode root, int key) {
        
    }
    
    private void solve(TreeNode node, int key)
    {
        if(node==null)
            return;
        if(node.val==key)
        {
            var temp=node;
            if(node.right!=null)
            {
                node=node.right;
            }
        }
        solve(node.left, key);
        solve(node.right, key);
    }
}
