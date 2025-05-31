package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathUsingDijkastra 
{
    public List<Integer> shortestPath(int n, int m, int edges[][]) 
    {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)->x.w-y.w);
        Integer dist[]=new Integer[n+1];
        Integer parent[]=new Integer[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=(int)1e9;
            parent[i]=i;
        }
        dist[1]=0;
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty())
        {
            var node=pq.poll();
            var ed=node.e;
            var wt=node.w;
            for(var it:adj.get(ed))
            {
                if(wt+it.w<=dist[it.e])
                {
                    dist[ed]=wt+it.w;
                    pq.add(new Pair(wt+it.w, dist[ed]));
                    parent[it.e]=ed;
                }
            }
        }
        List<Integer>path=new ArrayList<>();
        for(var it:dist)
        {
            if(it==(int)1e9)
            {
                path.add(-1);
                return path;
            }
        }
        int node=n;
        while(parent[node]!=node)
        {
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    class Pair
    {
        int w;
        int e;
        Pair(int w, int e)
        {
            this.w=w;
            this.e=e;
        }
    }
}
