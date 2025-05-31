package dailyproblems.graphs;

import java.util.PriorityQueue;

public class PathWithMinimumEffort 
{
    public static int MinimumEffort(int rows, int columns, int[][] heights) 
    {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Tuple>q=new PriorityQueue<>((x,y)->x.d-y.d);
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        q.add(new Tuple(0, 0, 0));
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            var node=q.poll();
            var diff=node.d;
            var r=node.r;
            var c=node.c;
            if(r==n-1 && c==m-1)
                return diff;
            
            for(int i=0;i<4;i++)
            {
                int rr=delr[i]+r;
                int cc=delc[i]+c;
                if(rr>=0 && rr<n && cc>=0 && cc<m)
                {
                    var newD=Math.max(Math.abs(heights[r][c]-heights[rr][cc]),diff);
                    if(newD<dist[rr][cc])
                    {
                        dist[rr][cc]=newD;
                        q.add(new Tuple(newD, rr, cc));
                    }
                }
            }
        }
        return 0;
    }
}

class Tuple
{
    int d;
    int r, c;
    Tuple(int d, int r, int c)
    {
        this.d=d;
        this.r=r;
        this.c=c;
    }
}
