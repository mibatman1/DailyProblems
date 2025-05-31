package dailyproblems.bst;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=problem-list-v2&envId=mmbknbs2
public class DeleteNodeInBST 
{
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer>ls=new ArrayList<>();
        solve(root, key, ls);
        var node=new TreeNode(ls.get(0));
        for(var i=1;i<ls.size();i++)
        {
            solve(node, ls.get(i));
        }
        return node;
    }

    private void solve(TreeNode node, int key, List<Integer>ls)
    {
        if(node==null)
            return;
        if(key==node.val)
            return;
        ls.add(node.val);
        solve(node.left, key, ls);
        solve(node.right, key, ls);
    }

    private void solve(TreeNode node, int val)
    {
        if(val<node.val)
        {
            if(node.left==null)
                node.left=new TreeNode(val);
            else
                solve(node.left, val);
        }
        else if(val>node.val)
        {
            if(node.right==null)
                node.right=new TreeNode(val);
            else
                solve(node.right, val);
        }
    }
}
