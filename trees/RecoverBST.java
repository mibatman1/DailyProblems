package trees;

public class RecoverBST 
{
    TreeNode first=null;
    TreeNode middle=null;
    TreeNode last=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        dfs(root);
        if(first!=null && middle!=null)
        {
            var temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        }
        if(first!=null && last!=null)
        {
            var temp=first.val;
            first.val=last.val;
            last.val=temp;
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
                middle=node;
            }
            else
            {
                last=node;
            }
        }
        prev=node;
        dfs(node.right);
    }
}
