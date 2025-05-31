package dailyproblems.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix 
{
    public int[][] updateMatrix(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }
        int delRow[]={1,0,-1,0};
        int delCol[]={0,-1,0,1};
        while(!q.isEmpty())
        {
            int first=q.peek().first;
            int second=q.peek().second;
            int steps=q.peek().third;
            q.poll();
            dist[first][second]=steps;
            for(int i=0;i<4;i++)
            {
                int nRow=first+delRow[i];
                int nCol=second+delCol[i];
                if(nRow<n && nRow>=0 && nCol<m && nCol>=0 && vis[nRow][nCol]==0)
                {
                    q.add(new Pair(nRow, nCol,steps+1));
                    vis[nRow][nCol]=1;
                }
            }
        }
        return dist;
    }
}

class Pair
{
    int first;
    int second;
    int third;
    Pair(int first, int second, int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
