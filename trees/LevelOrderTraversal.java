package dailyproblems.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        List<List<Integer>>res=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode r=q.poll();
                if(r.left!=null)
                    q.add(r.left);
                if(r.right!=null)
                    q.add(r.right);
                temp.add(r.val);
            }
            res.add(temp);
        }
        return res;   
    }

    public static void main(String[] args) {
        
    }
    
}
