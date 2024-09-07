package trees;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/

class Pair
{
    TreeNode node;
    int num;
    public Pair(TreeNode node, int num)
    {
        this.node=node;
        this.num=num;
    }
}


public class WidthOfTheBinaryTree 
{
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root==null)
            return 0;
        Queue<Pair>q=new ArrayDeque<>();
        int ans=0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty())
        {
            int size=q.size();
            int min=q.peek().num;
            int first=0, last=0;
            for(int i=0;i<size;i++)
            {
                int cur_id=q.peek().num-min;
                var node=q.peek();
                q.poll();
                if(i==0)
                    first=cur_id;
                if(i==size-1)
                    last=cur_id;
                if(root.left!=null)
                {
                    q.offer(new Pair(root.left, cur_id*2+1));
                }
                if(root.right!=null)
                {
                    q.offer(new Pair(root.right, cur_id*2+2));
                }
            }
            ans=Math.max(ans, last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
