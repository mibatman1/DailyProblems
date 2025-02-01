package potd;

public class MaximumNumberOfFishInAGrid 
{
    private int max=Integer.MIN_VALUE;
    private int dfs(int r, int c, boolean vis[][], int grid[][])
    {
        vis[r][c]=true;
        int ans=0;
        if(grid[r][c]==0)
            return ans;
        ans+=grid[r][c];
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nr=r+delRow[i];
            int nc=c+delCol[i];
            if(nr<grid.length && nr>=0 && nc<grid[0].length && nc>=0)
            {
                if(!vis[nr][nc])
                {
                    ans+=dfs(nr, nc, vis, grid);
                }
            }
        }
        return ans;
    }

    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                    continue;
                vis=new boolean[n][m];
                if(!vis[i][j])
                {
                    max=Math.max(max, dfs(i, j, vis, grid));
                }
            }
        }
        return max;   
    }
}
