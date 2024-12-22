package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze 
{
    int shortestPath(int[][] grid, int[] source, int[] destination) 
    {
        if(source[0]==destination[0] && source[1]==destination[1])
            return 0;
        
        Queue<Tuple>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j]=(int)1e9;
            }
        }
        dist[source[0]][source[1]]=0;
        q.add(new Tuple(0, source[0], source[1]));
        while(!q.isEmpty())
        {
            var node=q.poll();
            var rw=node.w;
            var rc=node.c;
            var rr=node.r;
            int delr[]={-1,0,1,0};
            int delc[]={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int dr=delr[i]+rr;
                int dc=delc[i]+rc;
                if(dr>=0 && dr<=n && dc>=0 && dc<=m && grid[dr][dc]==1 && (rw+1)<dist[dr][dc])
                {
                    dist[dr][dc]=rw+1;
                    if(dr==destination[0] && dc==destination[1])
                        return rw+1;
                    q.add(new Tuple(rw+1, dr, dc));
                }
            }
        }
        return -1;
    }

    class Tuple
    {
        int w, r, c;
        Tuple(int w, int r, int c)
        {
            this.w=w;
            this.r=r;
            this.c=c;
        }
    }
}
