package dailyproblems.bst;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal 
{
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        List<Integer>res=new ArrayList<>();
        solve(root, res);
        return res;
    }

    private void solve(TreeNode node, List<Integer>res)
    {
        if(node==null)
            return;
        res.add(node.val);
        solve(node.left, res);
        solve(node.right, res);
    }
}
