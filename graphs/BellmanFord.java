package graphs;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class BellmanFord 
{
    static int[] bellmanFord(int V, int[][] edges, int src) 
    {
        int dist[]=new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src]=0;
        for(int i=0;i<V-1;i++)
        {
            for(var it:edges)
            {
                var u=it[0];
                var v=it[1];
                var wt=it[2];
                if(dist[u]!=(int)1e8 && (dist[u]+wt)<dist[v])
                {
                    dist[v]=dist[u]+wt;                    
                }
            }
        }
        for(var it:edges)
        {
            var u=it[0];
            var v=it[1];
            var wt=it[2];
            if(dist[u]!=1e8 && dist[u]+wt<dist[v])
            {
                int temp[]=new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
}
