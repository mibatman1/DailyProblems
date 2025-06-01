package dailyproblems.binarytree;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPath 
{
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        Map<Integer, Integer>mp=new HashMap<>();    
    }
    
    private void solve(TreeNode node, Map<Integer, Integer>mp)
    {
        if(node==null)
        {
            for(var m:mp.values())
            {
                
            }
        }
        mp.put(node.val, mp.getOrDefault(node.val,0)+1);
        solve(node.left, mp);
        solve(node.right, mp);
    }
}
