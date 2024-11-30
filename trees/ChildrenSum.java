package trees;


// https://www.geeksforgeeks.org/problems/children-sum-parent/1
public class ChildrenSum 
{
    public int isSumProperty(TreeNode root)
    {
        if(root==null)
            return 0;
        int child=0;
        if(root.left!=null)
        {
            child+=root.left.val;
        }
        if(root.right!=null)
        {
            child+=root.right.val;
        }
        if(child>=root.val)
        {
            root.val=child;
        }
        else
        {
            if(root.left!=null)
            {
                root.left.val=root.val;
            }
            else if(root.right!=null)
            {
                root.right.val=root.val;
            }
        }
        isSumProperty(root.left);
        isSumProperty(root.right);
        int tot=0;
        if(root.left!=null)
            tot+=root.left.val;
        if(root.right!=null)
            tot+=root.right.val;
        if(root.left!=null || root.right!=null)
            root.val=tot;
    }
}
