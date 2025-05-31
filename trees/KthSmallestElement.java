package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/?envType=problem-list-v2&envId=m22zk1nr
public class KthSmallestElement {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer>ans=new ArrayList<>();
        solve(root, k, ans);
        return ans.get(k-1);   
    }

    void solve(TreeNode node, int k, List<Integer>ans)
    {
        if(node==null)
            return;
        if(node.left!=null)
            solve(node.left, k, ans);
        ans.add(node.val);

        if(ans.size()>=k)
            return;
        
        if(node.right!=null)
            solve(node.right, k, ans);
    }
}
