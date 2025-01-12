package trees;

public class SumOfRootToBinaryNumber 
{
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        solve(root, new StringBuilder());
        return sum;
    }

    void solve(TreeNode node, StringBuilder str)
    {
        if(node==null)
            return;
        if(node.left==null && node.right==null)
            sum+=Integer.parseInt(str.toString(), 2);
        if(node.left!=null)
            solve(node.left, str);
        if(node.right!=null)
            solve(node.right, str);
        str.deleteCharAt(str.length()-1);
    }
}
