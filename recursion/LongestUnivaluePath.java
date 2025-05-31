package dailyproblems.recursion;

public class LongestUnivaluePath 
{
    private Integer prev=null;
    private int cnt=0;
    private int ans=0;
    public int longestUnivaluePath(TreeNode root) 
    {
        postOrder(root);
        return ans;        
    }

    int postOrder(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int left=postOrder(node.left);
        int right=postOrder(node.right);
        int dirL=0, dirR=0;
        if(node.left!=null && node.val==node.left.val)
        {
            dirL=left+1;
        }
        if(node.right!=null && node.val==node.right.val)
        {
            dirR=right+1;
        }
        ans=Math.max(ans,dirL+dirR);
        return Math.max(dirL, dirR);
    }
}
