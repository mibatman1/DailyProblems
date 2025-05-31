package dailyproblems.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class Tuple
{
    TreeNode node;
    int col, row;
    public Tuple(TreeNode node, int col, int row)
    {
        this.node=node;
        this.col=col;
        this.row=row;
    }
}

public class VerticalTraversal 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>mp=new TreeMap<>();
        Queue<Tuple>q=new ArrayDeque<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty())
        {
            var tuple=q.poll();
            var node=tuple.node;
            int x=tuple.col;
            int y=tuple.row;
            if(!mp.containsKey(x))
            {
                mp.put(x,new TreeMap<>());
            }
            if(!mp.get(x).containsKey(y))
            {
                mp.get(x).put(y,new PriorityQueue<>());
            }
            mp.get(x).get(y).offer(node.val);
            if(node.left!=null)
            {
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if(node.right!=null)
            {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        List<List<Integer>>ls=new ArrayList<>();
        for(var r:mp.values())
        {
            ls.add(new ArrayList<>());
            for(var a:r.values())
            {
                while(!a.isEmpty())
                {
                    System.out.println(a.peek());
                    ls.get(ls.size()-1).add(a.poll());
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        
    }
}

