package dailyproblems.treedfs;

import java.util.ArrayList;
import java.util.List;

import dailyproblems.binarytree.TreeNode;

public class KthSmallestElementInBST 
{
    public int kthSmallest(TreeNode root, int k)
    {
        List<Integer>ans=new ArrayList<>();
        solve(root, k, ans);
        return ans.get(k-1);
    }
    
    private void solve(TreeNode node, int k, List<Integer>ans)
    {
        if(node==null)
            return;
        if(node.left!=null)
            solve(node.left, k, ans);
        ans.add(node.val);
        if(ans.size()==k)
            return;
        if(node.right!=null)
            solve(node.right, k, ans);
    }
}
