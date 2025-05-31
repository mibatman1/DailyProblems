package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair
{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}

public class DetectCycleUndirected 
{
    boolean detectCycle(boolean vis[], int src, ArrayList<ArrayList<Integer>>adj)
    {
        vis[src]=true;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.poll();
            for(var adjNode:adj.get(node))
            {
                if(vis[adjNode]==false)
                {
                    vis[adjNode]=true;
                    q.add(new Pair(adjNode, node));
                }
                else if(parent!=adjNode)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) 
    {
        int v=adj.size();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++)
            vis[i]=false;
        for(int i=0;i<v;i++)
        {
            if(vis[i]==false)
            {
                if(detectCycle(vis, i, adj))
                {
                    return true;
                }
            }
        }
        return false;
        // Code here
    }
    
}
