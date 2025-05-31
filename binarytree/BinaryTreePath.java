package dailyproblems.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath 
{
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String>ans=new ArrayList<>();
        solve(root, "", ans);
        return ans;
    }

    private void solve(TreeNode node, String s, List<String>ans)
    {
        if(node==null)
            return;
        s+=node.val;
        if(node.left==null || node.right==null)
        {
            ans.add(s);
        }
        s+="->";
        solve(node.left, s, ans);
        solve(node.right, s, ans);
    }
}
