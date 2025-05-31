package dailyproblems.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree 
{
    private Map<TreeNode, TreeNode>parent=new HashMap<>();
    private Set<TreeNode>vis=new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans=new ArrayList<>();
        buildParent(root);
        findTarget(target, 0, k, ans);
        return ans;
    }

    void buildParent(TreeNode node)
    {
        if(node.left!=null)
        {
            parent.put(node.left, node);
            buildParent(node.left);
        }
        if(node.right!=null)
        {
            parent.put(node.right, node);
            buildParent(node.right);
        }
    }

    void findTarget(TreeNode node, int dis, int k, List<Integer>ans)
    {
        if(node==null || vis.contains(node))
        {
            return;
        }
        if(k==dis)
        {
            ans.add(node.val);
            return;
        }
        vis.add(node);
        if(node.left!=null)
        {
            findTarget(node.left, dis+1, k, ans);
        }
        if(node.right!=null)
        {
            findTarget(node.right, dis+1, k, ans);
        }
        if(parent.get(node)!=null)
        {
            findTarget(parent.get(node), dis+1, k, ans);
        }
    }
}
