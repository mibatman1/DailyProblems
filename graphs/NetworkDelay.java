package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NetworkDelay 
{
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,0));
        int dist[]=new int[n];
        Arrays.fill(dist, -1);
        while(!q.isEmpty())
        {
            var node=q.poll();
            var first=node.first;
            var second=node.second;
            for(var it:adj.get(first))
            {
                var ed=it.first;
                var wt=it.second;
                if(wt+second<dist[ed])
                {
                    dist[ed]=wt+second;
                    q.add(new Pair(ed, wt+second));
                }
            }
        }
        Arrays.sort(dist);
        return dist[n-1];
    }
}

class Pair
{
    int first, second;
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
