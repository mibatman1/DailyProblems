package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination 
{
    static int countPaths(int n, List<List<Integer>> roads) 
    {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=roads.size();
        for(int i=0;i<m;i++)
        {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), 
            roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), 
            roads.get(i).get(2)));
        }
        PriorityQueue<Pair>q=new PriorityQueue<>((x,y)->x.first-y.first);
        q.add(new Pair(0, 0));
        int dist[]=new int[n];
        int ways[]=new int[n];
        Arrays.fill(dist,(int)1e9);
        Arrays.fill(ways,(int)1e9);
        dist[0]=0;
        ways[0]=1;
        int mod=(int)1e9+7;
        while(!q.isEmpty())
        {
            var node=q.poll();
            var wa=node.first;
            var na=node.second;
            for(var it:adj.get(na))
            {
                int ad=it.second;
                int wq=it.first;
                if(wa+wq<dist[ad])
                {
                    dist[ad]=wa+wq;
                    q.add(new Pair(wa+wq, ad));
                    ways[ad]=ways[na];
                }
                else if(wa+wq==dist[ad])
                {
                    ways[ad]=(ways[ad]+ways[na])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}

class Pair
{
    int first, second;
    Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
