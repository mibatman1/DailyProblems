package dailyproblems.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        if(root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        List<List<Integer>>res=new ArrayList<>();
        q.add(root);
        int l=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>temp=new ArrayList<>();
            for(var i=0;i<size;i++)
            {
                if(l%2==0)
                {
                    var node=q.poll();
                    temp.add(node.val);
                    if(node.left!=null)
                        q.add(node.left);
                    if(node.right!=null)
                        q.add(node.right);
                }
                else
                {
                    var node=q.poll();
                    temp.add(node.val);
                    if(node.right!=null)
                        q.add(node.right);
                    if(node.left!=null)
                        q.add(node.left);
                }
            }
            res.add(temp);
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
