package dailyproblems.trees;

public class RecoverBST 
{
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        dfs(root);
        if(first!=null && second!=null)
        {
            var temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    
    void dfs(TreeNode node)
    {
        if(node==null)
            return;
        dfs(node.left);
        if(prev!=null && prev.val>node.val)
        {
            if(first==null)
            {
                first=prev;
            }
            second=node;
        }
        prev=node;
        dfs(node.right);
    }
}
