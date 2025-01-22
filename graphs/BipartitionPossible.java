package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartitionPossible 
{
    boolean check(List<List<Integer>>adj, int color[], int i)
    {
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty())
        {
            var node=q.poll();
            for(var it:adj.get(node))
            {
                if(color[it]==-1)
                {
                    q.add(it);
                    color[it]=1-color[i];
                }
                else if(color[it]==color[i])
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes[0].length;i++)
        {
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int color[]=new int[n];
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(check(adj, color, i))
                    return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=4;
        int arr[][]={{1,2},{1,3},{2,4}};
        BipartitionPossible bipartitionPossible=new BipartitionPossible();
        System.out.println(bipartitionPossible.possibleBipartition(n, arr));
    }
}
