package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgo 
{
    ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int v=adj.size();
        int vis[]=new int[v];
        int inDeg[]=new int[v];
        for(int i=0;i<v;i++)
        {
            for(var it:adj.get(i))
            {
                inDeg[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(inDeg[i]==0)
            {
                q.add(inDeg[i]);   
            }
        }
        ArrayList<Integer>res=new ArrayList<>();
        while(!q.isEmpty())
        {
            var node=q.poll();
            res.add(node);
            for(var it:adj.get(node))
            {
                inDeg[it]--;
                if(inDeg[it]==0)
                {
                    q.add(it);
                }
            }
        }
        return res;
    }    
}
