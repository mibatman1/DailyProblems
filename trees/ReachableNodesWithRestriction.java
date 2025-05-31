package dailyproblems.trees;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reachable-nodes-with-restrictions/?envType=problem-list-v2&envId=depth-first-search
public class ReachableNodesWithRestriction 
{
    private int cnt=0;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>>adj=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(var it:edges)
        {
            var u=it[0];
            int v=it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(var it:restricted)
        {
            vis[it]=true;
        }
        if(vis[0]==true)
            return 0;
        dfs(adj, 0, vis);
        return cnt;
    }

    void dfs(List<List<Integer>>adj, int idx, boolean vis[])
    {
        vis[idx]=true;
        cnt++;
        for(var it:adj.get(idx))
        {
            if(vis[it]==false)
                dfs(adj, idx+1, vis);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
            {0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}
        };

        int res[]={};

        ReachableNodesWithRestriction reachableNodesWithRestriction=new ReachableNodesWithRestriction();
        System.out.println(reachableNodesWithRestriction.reachableNodes(7, edges, res));
    }
}
