package potd;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection 
{
    boolean dfs(int src, int parent, boolean vis[], List<List<Integer>>adj)
    {
        vis[src]=true;
        for(var it:adj.get(src))
        {
            if(vis[it]!=true)
            {
                if(dfs(it, src, vis, adj))
                    return true;
            }
            else if(parent!=it)
                return true;
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        int n=edges.length;
        int m=edges[0].length;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        boolean vis[]=new boolean[n];
        for(var it:edges)
        {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
            if(dfs(it[0], -1, vis, adj))
            {
                return new int[]{it[0], it[1]};
            }
        }
        return new int[0];   
    }
}
