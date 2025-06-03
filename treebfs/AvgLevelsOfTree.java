package dailyproblems.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dailyproblems.binarytree.TreeNode;

public class AvgLevelsOfTree 
{
    public List<Double> averageOfLevels(TreeNode root) 
    {
        List<Double>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            var size=q.size();
            double sum=0;
            for(var i=0;i<size;i++)
            {
                var node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }    
}
