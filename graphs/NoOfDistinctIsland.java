package dailyproblems.graphs;

import java.util.ArrayList;
import java.util.HashSet;

// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class NoOfDistinctIsland 
{
    void dfs(int row, int col, int vis[][], int grid[][], ArrayList<String>s, int row0, int col0)
    {
        vis[row][col]=1;
        s.add(toString(row-row0, col-col0));
        int n=grid.length;
        int m=grid[0].length;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<=n && ncol>=0 && ncol<=m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                dfs(nrow, ncol, vis, grid, s, row0, col0);
            }
        }
    }

    private String toString(int r, int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>>st=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1 && vis[i][j]==0)
                {
                    ArrayList<String>s=new ArrayList<>();
                    dfs(i,j,vis,grid,s,i,j);
                    st.add(s);
                }
            }
        }
        return st.size();
    }
}

class Pair
{
    int first;
    int second;
    public Pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
