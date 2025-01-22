package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindShortestCycleInAGraph 
{
    private int min=Integer.MAX_VALUE;
    private int count=0;
    
    int check(List<List<Integer>>adj, int color[], int i)
    {
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i, -1));
        color[i]=1;
        while(!q.isEmpty())
        {
            var node=q.poll();
            var parent=node.second;
            var src=node.first;
            for(var it:adj.get(src))
            {
                if(color[it]==-1)
                {
                    q.add(new Pair(it, src));
                    color[it]=1;
                    count++;
                }
                else if(it!=parent)
                {
                    min=Math.min(min, count+1);
                    count=0;
                    return min;
                }
            }
        }
        count=0;
        return -1;
    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(var it:edges)
        {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        int color[]=new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                check(adj, color, i);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;   
    }

    public static void main(String[] args) {
        int n=7;
        int arr[][]={{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
        FindShortestCycleInAGraph findShortestCycleInAGraph=new FindShortestCycleInAGraph();
        System.out.println(findShortestCycleInAGraph.findShortestCycle(n, arr));
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
}


