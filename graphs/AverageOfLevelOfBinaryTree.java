package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class AverageOfLevelOfBinaryTree 
{
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        List<Double>ans=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            var size=q.size();
            int sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                res.add(node.val);
            }
            ans.add((double)sum/q.size());
        }
        return ans;
    }
}


