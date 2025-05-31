package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII 
{
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        solve(root, targetSum, ans, a);
        return ans;
    }

    void solve(TreeNode node, int sum, List<List<Integer>>ans, List<Integer>a)
    {
        if(node==null)
        {
            return;
        }
        a.add(node.val);
        if(node.left==null && node.right==null && sum==node.val)
        {
            ans.add(new ArrayList<>(a));
        }
        solve(node.left, sum-node.val, ans, a);
        solve(node.right, sum-node.val, ans, a);
        a.remove(a.size()-1);
    }
}
