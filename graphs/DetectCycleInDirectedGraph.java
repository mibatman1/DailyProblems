package dailyproblems.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleInDirectedGraph 
{
    boolean check(int v, int vis[], int pathVis[], ArrayList<ArrayList<Integer>>adj, int i)
    {
        vis[i]=1;
        pathVis[i]=1;
        for(var it:adj.get(i))
        {
            if(vis[it]==0)
            {
                if(check(v, vis, pathVis, adj, it)==true)
                    return true;
            }
            else if(pathVis[it]==1)
            {
                return true;
            }
        }
        pathVis[i]=0;
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int v=adj.size();
        int vis[]=new int[v];
        int pathVis[]=new int[v];
        for(int i=0;i<v;i++)
        {
            if(check(v, vis, pathVis, adj, i)==true)
            {
                return true;
            }
        }
        return false;
    }
}
