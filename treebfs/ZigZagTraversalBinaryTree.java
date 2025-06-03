package dailyproblems.treebfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyproblems.binarytree.TreeNode;

public class ZigZagTraversalBinaryTree 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        var flag=0;
        while(!q.isEmpty())
        {
            var size=q.size();
            List<Integer>temp=new ArrayList<>();
            for(var i=0;i<size;i++)
            {
                var node=q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                temp.add(node.val);
            }
            if(flag%2!=0)
            {
                Collections.reverse(temp);
                ans.add(temp);
            }
            else
            {
                ans.add(temp);
            }
            flag++;
        }
        return ans;
    }    
}
