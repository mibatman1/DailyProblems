package dailyproblems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalII 
{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            int s=q.size();
            List<Integer>res=new ArrayList<>();
            for(int i=0;i<s;i++)
            {
                var node=q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                res.add(node.val);
            }
            ans.add(0, res);
        }
        return ans;
    }
}
