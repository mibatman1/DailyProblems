package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees 
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges) 
    {
        List<List<Integer>>adj=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        // if(n==1 || n==2)
        // {
        //     for(int i=0;i<n;i++)
        //         ans.add(i);
        //     return ans;
        // }
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int inDeg[]=new int[n];
        Arrays.fill(inDeg, 0);
        for(var it:edges)
        {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
            inDeg[it[1]]++;
            inDeg[it[0]]++;
        }
        System.out.println(adj);
        // for(var t:inDeg)
        //     System.out.print(t);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<adj.size();i++)
        {
            if(inDeg[i]==1)
            {
                q.add(inDeg[i]);
                inDeg[i]--;
            }
        }
        while(!q.isEmpty())
        {
            ans=new ArrayList<>();
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                var node=q.poll();
                ans.add(node);
                for(var it:adj.get(node))
                {
                    inDeg[it]--;
                    if(inDeg[it]==1)
                    {
                        q.add(it);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][]={{1,0},{1,2},{1,3}};
        int n=4;
        MinimumHeightTrees minimumHeightTrees=new MinimumHeightTrees();
        System.out.println(minimumHeightTrees.findMinHeightTrees(n, arr));
    }
}
