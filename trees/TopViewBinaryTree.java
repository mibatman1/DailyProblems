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

public class TopViewBinaryTree 
{
    public ArrayList<Integer> topView(TreeNode root) 
    {
        ArrayList<Integer>res=new ArrayList<>();
        if(root==null)
            return res;
        Map<Integer, Integer>mp=new HashMap<>();
        Queue<Nodem>q=new ArrayDeque<>();
        q.add(new Nodem(root, 0));
        while(!q.isEmpty())
        {
            var pair=q.poll();
            var node=pair.node;
            int point=pair.point;
            if(mp.get(point)==null)
            {
                mp.put(point,node.val);
            }
            if(node.left!=null)
            {
                q.add(new Nodem(node.left, point-1));
            }
            if(node.right!=null)
            {
                q.add(new Nodem(root.right, point+1));
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
