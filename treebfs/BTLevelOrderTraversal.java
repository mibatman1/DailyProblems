package dailyproblems.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyproblems.binarytree.TreeNode;

public class BTLevelOrderTraversal 
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        Queue<TreeNode>q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            var s=q.size();
            List<Integer>temp=new ArrayList<>();
            for(var i=0;i<s;i++)
            {
                var node=q.poll();
                temp.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }     
}
