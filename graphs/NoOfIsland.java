package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfIsland 
{
    private void bfs(int row, int col, int vis[][], char grid[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(row, col));
        while(!q.isEmpty())
        {
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();
            for(int delRow=-1;delRow<=1;delRow++)
            {
                for(int delCol=-1;delCol<=1;delCol++)
                {
                    int drow=r+delRow;
                    int dcol=c+delCol;
                    if(drow<=0 && drow<n && dcol<=0 && dcol<m && grid[drow][dcol]=='1' && vis[drow][dcol]==0)
                    {
                        q.add(new Pair(drow, dcol));
                    }
                }
            }
        }        
    }

    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    bfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        
    }
}
