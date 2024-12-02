package graphs;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort 
{
    void dfs(int i, int vis[], ArrayList<Integer>res, ArrayList<ArrayList<Integer>>adj)
    {
        vis[i]=1;
        for(var it:adj.get(i))
        {
            if(vis[it]==0)
            {
                dfs(it, vis, res, adj);
            }
        }
        res.add(i);
    }

    ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) 
    {
        int v=adj.size();
        int vis[]=new int[v];
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0)
            {
                dfs(i, vis, res, adj);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort=new TopologicalSort();
        System.out.println();
    }
}
