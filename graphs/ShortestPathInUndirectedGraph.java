package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
public class ShortestPathInUndirectedGraph 
{
    public int[] shortestPath(int[][] edges,int n,int m ,int src) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int dist[]=new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src]=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(dist[src]);
        while(!q.isEmpty())
        {
            var node=q.poll();
            for(var it:adj.get(node))
            {
                if(dist[node]+1<dist[it])
                {
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(dist[i]==1e9)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
}
