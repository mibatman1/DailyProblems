package potd;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates 
{
    boolean checkN(List<List<Integer>>adj, int vis[], int check[], int pathCheck[], int i)
    {
        vis[i]=1;
        pathCheck[i]=1;
        for(var it:adj.get(i))
        {
            if(vis[it]==0)
            {
                if(checkN(adj, vis, check, pathCheck, it)==true)
                {
                    check[i]=0;
                    return true;
                }
            }
            else if(pathCheck[it]==1)
            {
                check[i]=0;
                return true;
            }
        }
        check[i]=1;
        pathCheck[i]=0;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) 
    {
        List<Integer>ans=new ArrayList<>();
        int n=graph.length;
        int m=graph[0].length;
        int vis[]=new int[n];
        int check[]=new int[n];
        int pathCheck[]=new int[n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(var it:graph)
        {
            adj.get(it[0]).add(it[1]);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                checkN(adj, vis, check, pathCheck, i);
            }
        }
        for(var it:check)
        {
            if(it==1)
            {
                ans.add(it);
            }
        }
        return ans;   
    }
}
