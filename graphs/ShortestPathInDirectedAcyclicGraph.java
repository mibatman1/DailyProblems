package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph 
{
    void topo(int node, ArrayList<ArrayList<Pair>>adj, int vis[], Stack<Integer>st)
    {
        vis[node]=1;
        for(int i=0;i<adj.get(i).size();i++)
        {
            int v=adj.get(node).get(i).first;
            if(vis[v]==0)
            {
                topo(v, adj, vis, st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) 
    {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            ArrayList<Pair>temp=new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<E;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int vis[]=new int[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                topo(i, adj, vis, st);
            }
        }
        int dist[]=new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i]=(int)1e9;
        }
        dist[0]=0;
        while(!st.isEmpty())
        {
            var node=st.pop();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;
                if(dist[node]+wt<dist[v])
                {
                    dist[v]=wt+dist[node];
                }
            }
        }
        return dist;
    }
}

class Pair
{
    int first;
    int second;

    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
