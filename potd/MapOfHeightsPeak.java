package potd;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHeightsPeak 
{
    public int[][] highestPeak(int[][] isWater) 
    {
        int n=isWater.length;
        int m=isWater[0].length;
        int vis[][]=new int[n][m];
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
        for(var it:vis)
        {
            Arrays.fill(it, -1);
        }
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(isWater[i][j]==1)
                {
                    q.add(new Pair(i, j));
                    vis[i][j]=0;
                }
            }
        }
        int height=1;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                var node=q.poll();
                var row=node.r;
                var col=node.c;
                for(int d=0;d<4;d++)
                {
                    int r=row+delRow[d];
                    int c=col+delCol[d];
                    if(r<n && r>=0 && c<m && c>=0 && vis[r][c]==-1)
                    {
                        vis[r][c]=height;
                        q.add(new Pair(r, c));
                    }
                }
            }
            height++;
        }
        return vis; 
    }

    class Pair
    {
        int r, c;
        public Pair(int r, int c)
        {
            this.r=r;
            this.c=c;
        }
    }
}
