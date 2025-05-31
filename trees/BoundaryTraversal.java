package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal 
{
    private boolean checkLeafNode(TreeNode node)
    {
        if(node.left==null && node.right==null)
            return true;
        return false;
    }

    private void addLeftBoundaryNode(TreeNode node, List<Integer>res)
    {
        var leftNode=node.left;
        while(leftNode!=null)
        {
            if(!checkLeafNode(leftNode))
            {
                res.add(leftNode.val);
            }
            if(leftNode.left!=null)
                addLeftBoundaryNode(leftNode.left, res);
            else
                leftNode=leftNode.right;
        }
    }

    private void addRightBoundaryNode(TreeNode node, List<Integer>res)
    {
        var rightNode=node.right;
        List<Integer>r=new ArrayList<>();
        while(rightNode!=null)
        {
            if(!checkLeafNode(rightNode))
            {
                r.add(rightNode.val);
            }
            if(rightNode.right!=null)
                addLeftBoundaryNode(rightNode.right, res);
            else
                rightNode=rightNode.left;
        }
        for(var i=r.size()-1;i>=0;i--)
        {
            res.add(r.get(i));
        }
    }

    private void addLeafNode(TreeNode node, List<Integer>res)
    {
        if(checkLeafNode(node))
        {
            res.add(node.val);
            return;
        }
        if(node.left!=null)
            addLeafNode(node.left, res);
        if(node.right!=null)
            addLeafNode(node.right, res);
    }

    public List<Integer>boundaryTraversal(TreeNode root)
    {
        List<Integer>res=new ArrayList<>();
        addLeftBoundaryNode(root,res);
        addLeafNode(root, res);
        addRightBoundaryNode(root, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello from somewhere");
    }
}
