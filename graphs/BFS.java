package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        ArrayList<Integer>res=new ArrayList<>();
        boolean vis[]=new boolean[V];
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty())
        {
            var node=q.poll();
            q.add(node);
            for(var a:adj.get(node))
            {
                if(vis[a]!=true)
                {
                    vis[a]=true;
                    q.add(a);
                }
            }
        }
        return res;
    }
}
