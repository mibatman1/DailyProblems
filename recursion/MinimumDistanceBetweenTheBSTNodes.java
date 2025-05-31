package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenTheBSTNodes 
{
    private Integer p=null;
    private int min=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) 
    {
        inorder(root);
        return min;
        // List<Integer>ls=new ArrayList<>();
        // inOrder(root, ls);
        // int minDiff=Integer.MAX_VALUE;
        // for(int i=0;i<ls.size()-1;i++)
        // {
        //     minDiff=Math.min(minDiff, ls.get(i+1)-ls.get(i));
        // }
        // return minDiff;
    }

    void inorder(TreeNode node)
    {
        if(node==null)
            return;
        inorder(node.left);
        if(p!=null)
        {
            min=Math.min(min,node.val-p);
        }
        p=node.val;
        inorder(node.right);
    }

    // void inOrder(TreeNode node, List<Integer>ls)
    // {
    //     if(node==null)
    //         return;
    //     inOrder(node.left, ls);
    //     ls.add(node.val);
    //     inOrder(node.right, ls);
    // }
}






class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;     
    }
}
