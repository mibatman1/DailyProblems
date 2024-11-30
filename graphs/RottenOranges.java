package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges 
{
    public int orangesRotting(int[][] mat) 
    {
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        int cntFresh=0;
        for(int i=0; i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else
                {
                    vis[i][j]=0;
                }
                if(mat[i][j]==1)
                    cntFresh++;
            }
        }
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        int tm=0;
        int cnt=0;
        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int time=q.peek().time;
            q.poll();
            tm=Math.max(time,tm);
            for(int i=0;i<4;i++)
            {
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow<n && nRow>=0 && nCol<m && nCol>=0 && mat[nRow][nCol]==1 && vis[nRow][nCol]==0)
                {
                    q.add(new Pair(nRow, nCol, time+1));
                    vis[nRow][nCol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh)
            return -1;
        return tm;
    }
}

class Pair
{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time)
    {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
