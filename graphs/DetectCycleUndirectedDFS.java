package graphs;

import java.util.ArrayList;

public class DetectCycleUndirectedDFS 
{
    boolean detectCycle(int src, int parent, boolean vis[], ArrayList<ArrayList<Integer>>adj)
    {
        vis[src]=true;
        for(var adjNode:adj.get(src))
        {
            if(vis[adjNode]==false)
            {
                if(detectCycle(adjNode, src, vis, adj)==true)
                    return true;
            }
            else if(parent!=adjNode)
                return true;
        }
        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj)
    {
        int v=adj.size();
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(vis[i]==false)
            {
                if(detectCycle(i, -1, vis, adj)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
