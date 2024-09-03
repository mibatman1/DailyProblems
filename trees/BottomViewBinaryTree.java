package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Nodem
{
    TreeNode node;
    int point;
    public Nodem(TreeNode node, int point)
    {
        this.node=node;
        this.point=point;
    }
}

public class BottomViewBinaryTree 
{
    public ArrayList <Integer> bottomView(Nodem root)
    {
        ArrayList<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Map<Integer, Integer>mp=new HashMap<>();
        Queue<Nodem>q=new ArrayDeque<>();
        root.point=0;
        q.add(root);
        while(!q.isEmpty())
        {
            var node=q.poll();
            int point=node.point;
            mp.put(point,node.node.val);
            if(node.node.left!=null)
            {
                point=point-1;
                q.add(node.node.left);
            }
            if(node.node.right!=null)
            {
                point=point+1;
                q.add(node.node.right);
            }
        }
        for(var s:mp.values())
        {
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}
