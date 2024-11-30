package graphs;

import java.util.ArrayList;

//https://leetcode.com/problems/number-of-provinces/description/
public class NoOfProvinces 
{
    private void dfs(int vis[], ArrayList<ArrayList<Integer>>adjMat, int i)
    {
        vis[i]=1;
        for(var it:adjMat.get(i))
        {
            if(vis[it]==0)
            {
                dfs(vis, adjMat, it);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) 
    {
        ArrayList<ArrayList<Integer>>adjMat=new ArrayList<>();
        int V=isConnected.length;
        for(int i=0;i<V;i++)
        {
            adjMat.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adjMat.get(i).add(j);
                    adjMat.get(j).add(i);
                }
            }
        }
        int vis[]=new int[V];
        int cnt=0;
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                cnt++;
                dfs(vis, adjMat,i);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        
    }
}
