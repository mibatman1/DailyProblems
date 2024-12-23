package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops 
{
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) 
    {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(0,src, 0));
        int dist[]=new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[0]=0;
        while(!q.isEmpty())
        {
            var sq=q.poll();
            var c=sq.c;
            var st=sq.st;
            var sr=sq.n;
            if(st>k)
            {
                continue;
            }
            for(var it:adj.get(sr))
            {
                var ed=it.w;
                var ad=it.an;
                if(ed+c<dist[ad] && st<=k)
                {
                    dist[ad]=ed+c;
                    q.add(new Tuple(st+1, ad, ed+c));
                }
            }
        }
        for(var it:dist)
        {
            if(it==1e9)
                return -1;
        }
        return dist[dst];
    }
}

class Pair
{
    int an, w;
    Pair(int an, int w)
    {
        this.an=an;
        this.w=w;
    }
}

class Tuple
{
    int st,n,c;
    Tuple(int st, int n, int c)
    {
        this.st=st;
        this.n=n;
        this.c=c;
    }
}
