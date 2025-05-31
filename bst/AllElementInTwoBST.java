package dailyproblems.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/?envType=problem-list-v2&envId=mmbknbs2
public class AllElementInTwoBST 
{
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>res=new ArrayList<>();
        solve(root1, res);
        solve(root2, res);
        Collections.sort(res);
        return res;   
    }

    private void solve(TreeNode root, List<Integer>res)
    {
        if(root==null)
            return;
        res.add(root.val);
        solve(root.left, res);
        solve(root.right, res);
    }
}
