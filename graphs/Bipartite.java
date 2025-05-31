package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/bipartite-graph/1
public class Bipartite 
{
    boolean check(ArrayList<ArrayList<Integer>>adj, int color[], int i, int V)
    {
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty())
        {
            var s=q.poll();
            for(var it:adj.get(s))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[s];
                    q.add(it);
                }
                else if(color[it]==color[s])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) 
    {
        int V=adj.size();
        int color[]=new int[V];
        Arrays.fill(color, -1);
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(check(adj, color, i, V)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
