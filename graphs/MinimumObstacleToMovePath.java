package dailyproblems.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/editorial/?envType=problem-list-v2&envId=mmnpz31h
public class MinimumObstacleToMovePath 
{
    // public int minimumObstacles(int[][] grid) {
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     int check[][]=new int[n][m];
    //     int delRow[]={-1,0,+1,0};
    //     int delCol[]={0,+1,0,-1};
    //     for(var it:check)
    //         Arrays.fill(it,(int)1e9);
    //     PriorityQueue<Tuple>q=new PriorityQueue<>((a,b)->a.w-b.w);
    //     q.add(new Tuple(0, 0, 0));
    //     check[0][0]=0;
    //     while(!q.isEmpty())
    //     {
    //         var node=q.poll();
    //         var cost=node.w;
    //         var row=node.r;
    //         var col=node.c;

    //         if(cost<check[row][col])
    //             continue;
    //         if(row==n-1 && col==m-1)
    //             return cost;
    //         for(int i=0;i<4;i++)
    //         {
    //             int nrow=row+delRow[i];
    //             int ncol=col+delCol[i];
    //             if(nrow<n && nrow>=0 && ncol<m && ncol>=0)
    //             {
    //                 int newCost=cost+grid[nrow][ncol];
    //                 if(newCost<check[nrow][ncol])
    //                 {
    //                     check[nrow][ncol]=newCost;
    //                     q.add(new Tuple(newCost, nrow, ncol));
    //                 }
    //             }
    //         }
    //     }
    //     return check[n-1][m-1];
    // }

    public int minimumObstacles(int grid[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        int check[][]=new int[n][m];
        for(var it:check)
            Arrays.fill(it, (int)1e9);
        Deque<Tuple>q=new ArrayDeque<>();
        q.addFirst(new Tuple(0, 0, 0));
        check[0][0]=0;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        while(!q.isEmpty())
        {
            var node=q.pollFirst();
            var cost=node.c;
            var row=node.r;
            var col=node.c;

            for(int i=0;i<4;i++)
            {
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];

                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && check[nrow][ncol]==(int)1e9)
                {
                    if(grid[nrow][ncol]==1)
                    {
                        check[nrow][ncol]=cost+1;
                        q.addLast(new Tuple(cost+1, nrow, ncol));
                    }
                    else
                    {
                        check[nrow][ncol]=cost;
                        q.addFirst(new Tuple(cost, nrow, ncol));
                    }
                }
            }
        }
        return check[n-1][m-1];
    }
}

class Tuple
{
    int w, r, c;
    public Tuple(int w, int r, int c)
    {
        this.w=w;
        this.r=r;
        this.c=c;
    }
}
