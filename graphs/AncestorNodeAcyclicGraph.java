package graphs;

import java.util.ArrayList;
import java.util.List;

public class AncestorNodeAcyclicGraph 
{
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }

        List<List<Integer>>graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean vis[]=new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(graph, i, i, res, vis);
        }

        // for (int i = 0; i < n; i++) {
        //     res.get(i).sort(Integer::compareTo);
        // }

        return res;
    }

    private void dfs(List<List<Integer>>graph, int parent, int curr, List<List<Integer>> res, boolean[] visit) {
        visit[curr] = true;
        for (int dest : graph.get(curr)) {
            if (!visit[dest]) {
                System.out.println(dest+"----"+parent);
                res.get(dest).add(parent);
                dfs(graph, parent, dest, res, visit);
            }
        }
    }

    // void dfs(List<List<Integer>>adj, List<List<Integer>>ans, boolean vis[], int parent, int curr)
    // {
    //     //System.out.println("IO"+src);
    //     vis[curr]=true;
    //     for(var it:adj.get(curr))
    //     {
    //         if(vis[it]==false)
    //         {
    //         //System.out.println(ans.get(anc));
    //             ans.get(it).add(parent);
    //             dfs(adj, ans, vis, parent, it);
    //         }
    //     }
    // }

    public static void main(String[] args) {
        int edges[][]={{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        int n=8;
        AncestorNodeAcyclicGraph acyclicGraph=new AncestorNodeAcyclicGraph();
        //acyclicGraph.getAncestors(n, edges);
        System.out.println(acyclicGraph.getAncestors(n, edges));
    }
}
