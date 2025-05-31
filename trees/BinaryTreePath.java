package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath 
{
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        solve(root, ans, new StringBuilder());
        return ans;
    }

    void solve(TreeNode node, List<String>ans, StringBuilder str)
    {
        if(node==null)
            return;
        str.append(node.val);
        if(node.left==null && node.right==null)
        {
            ans.add(str.toString());
            return;
        }
        str.append("->");
        solve(node.left, ans, str);
        solve(node.right, ans, str);
    }
}
