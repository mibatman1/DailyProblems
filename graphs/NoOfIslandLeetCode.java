package dailyproblems.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslandLeetCode 
{
    void solve(char grid[][], int vis[][], int r, int c)
    {
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(r, c));
        while(!q.isEmpty())
        {
            var node=q.poll();
            var rr=node.first;
            var cc=node.second;
            int delRow[]={-1, 0, 1, 0};
            int delCol[]={0, 1, 0, -1};
            for(int i=0;i<4;i++)
            {
                int rn=rr+delRow[i];
                int cn=cc+delCol[i];
                if(rn<n && rn>=0 && cn<m && cn>=0 && vis[rn][cn]!=1 && grid[rn][cn]=='1')
                {
                    q.add(new Pair(rn, cn));
                    vis[rn][cn]=1;
                }
            }
        }
    }

    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m]; 
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis[i], 0);
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]!=1)
                {
                    solve(grid, vis, i, j);
                    cnt++;
                }
            }
        }
        return cnt;   
    }
    
}

class Pair
{
    int first, second;
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
