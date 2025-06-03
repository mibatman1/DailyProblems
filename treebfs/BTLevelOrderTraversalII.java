package dailyproblems.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyproblems.binarytree.TreeNode;

public class BTLevelOrderTraversalII 
{
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            var s=q.size();
            List<Integer>temp=new ArrayList<>();
            for(var i=0;i<s;i++)
            {
                var node=q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                temp.add(node.val);
            }
            res.add(0,temp);
        }
        return res;
    }
}
