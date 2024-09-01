package trees;

public class DiameterBinaryTree 
{
    public int findMax(TreeNode root, int maxi[])
    {
        if(root==null)
            return 0;
        int lh=findMax(root.left, maxi);
        int rh=findMax(root.right, maxi);
        maxi[0]=Math.max(maxi[0], rh+lh);
        return 1+Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) 
    {
        int dia[]=new int[1];
        findMax(root, dia);
        return dia[0];
    }
}
