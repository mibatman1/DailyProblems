package graphs;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/problems/eventual-safe-states/1
public class EventualSafeNode 
{
    boolean check(int vis[], int pathVis[], List<List<Integer>>adj, int i, int check[])
    {
        vis[i]=1;
        pathVis[i]=1;
        check[i]=0;
        for(var it:adj.get(i))
        {
            if(vis[it]==0)
            {
                if(check(vis, pathVis, adj, it, check)==true)
                {
                    check[i]=0;
                    return true;
                }
            }
            else if(pathVis[it]==1)
            {
                check[i]=0;
                return true;
            }
        }
        check[i]=1;
        pathVis[i]=0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) 
    {
        int vis[]=new int[V];
        int pathVis[]=new int[V];
        int check[]=new int[V];
        List<Integer>safeNode=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                check(vis, pathVis, adj, i, check);
            }  
        }
        for(int i=0;i<V;i++)
        {
            if(check[i]==1)
            {
                safeNode.add(i);
            }
        }
        return safeNode;
    }
}
