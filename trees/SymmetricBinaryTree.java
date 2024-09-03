package trees;

public class SymmetricBinaryTree 
{
    private boolean isSym(TreeNode leftNode, TreeNode rightNode)
    {
        if(leftNode==null || rightNode==null)
            return leftNode==rightNode;
        if(leftNode.val!=rightNode.val)
            return false;
        return isSym(leftNode.left, rightNode.right) && isSym(leftNode.right, rightNode.left);
    }

    public boolean isSymmetric(TreeNode root) 
    {
        return root==null || isSym(root.left, root.right);
    }

    public static void main(String[] args) {
        
    }
}
