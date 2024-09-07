package trees;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor 
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        var leftNode=lowestCommonAncestor(root.left, p, q);
        var rightNode=lowestCommonAncestor(root.right, p, q);
        if(leftNode==null)
            return rightNode;
        else if(rightNode==null)
            return leftNode;
        else
            return root;
    }

    public static void main(String[] args) {
        
    }
}
