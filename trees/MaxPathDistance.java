package trees;

public class MaxPathDistance 
{
    public int maxDepth(TreeNode root, int maxi[])
    {
        if(root==null)
            return 0;
        int lh=Math.max(0, maxDepth(root.left, maxi));
        int rh=Math.max(0, maxDepth(root.right, maxi));
        maxi[0]=Math.max(maxi[0], lh+rh+root.val);
        return Math.max(lh, rh)+root.val;
    }

    public int maxPathSum(TreeNode root) 
    {
        int arr[]=new int[1];
        arr[0]=Integer.MIN_VALUE;
        maxDepth(root,arr);
        return arr[0];        
    }

    public static void main(String[] args) {
        
    }
}
