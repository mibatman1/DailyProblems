package dailyproblems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryRightSideView 
{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(var i=0;i<size;i++)
            {
                var node=q.poll();
                if(i==0)
                    res.add(node.val);
                if(node.right!=null)
                    q.add(node.right);
                if(node.left!=null)
                    q.add(node.left);
            }
        }
        return res;
    }
}
