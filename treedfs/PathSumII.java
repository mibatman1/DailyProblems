package dailyproblems.treedfs;

import java.util.ArrayList;
import java.util.List;

import dailyproblems.binarytree.TreeNode;

public class PathSumII 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(root, targetSum, ans, ls);
        return ans;
    }

    private void solve(TreeNode node, int targetSum, List<List<Integer>>ans, List<Integer>ls)
    {
        if(node==null)
            return;
        ls.add(node.val);
        if(node.left==null && node.right==null && node.val==targetSum)
        {
            ans.add(ls);
        }
        solve(node.left, targetSum-node.val, ans, ls);
        solve(node.right, targetSum-node.val, ans, ls);
        ls.remove(ls.size()-1);
    }
}
