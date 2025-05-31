package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetecCycleInDAGUsingKahnsAlgo 
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int inDeg[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(var it:adj.get(i))
            {
                inDeg[it]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(inDeg[i]==0)
            {
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty())
        {
            var node=q.poll();
            cnt++;
            for(var it:adj.get(node))
            {
                inDeg[it]--;
                if(inDeg[it]==0)
                    cnt++;
            }
        }
        if(cnt==V)
            return false;
        return false;
    }
}
