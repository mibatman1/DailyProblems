package dailyproblems.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree 
{
    public int minDepth(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int depth=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                var node=q.poll();
                if(node.left==null && node.right==null)
                    return depth;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            depth++;
        }
        return 0;
    }
}
