package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinimumCostToMakeOneValidPath 
{
    // public int minCost(int[][] grid) {
    //     int check[][]=new int[grid.length][grid[0].length];
    //     for(var it:grid)
    //         Arrays.fill(it,(int)1e9);
    //     PriorityQueue<Tuple>q=new PriorityQueue<>((a, b)->a.cost-b.cost);
    //     q.add(new Tuple(0, 0, 0));
    //     int delRow[]={-1,0,+1,0};
    //     int delCol[]={0,+1,0,-1};
    //     check[0][0]=0;
    //     while(!q.isEmpty())
    //     {
    //         var node=q.poll();
    //         int ct=node.cost;
    //         var row=node.row;
    //         var col=node.col;
    //         if(ct<check[row][col])
    //             continue;
    //         for(int i=0;i<4;i++)
    //         {
    //             int nrow=row+delRow[i];
    //             int ncol=col+delCol[i];

    //             if(nrow<grid.length && nrow>=0 && ncol<grid[0].length && ncol>=0)
    //             {
    //                 int newCost=ct+(i+1==grid[nrow][ncol]?0:1);
    //                 if(newCost < check[nrow][ncol])
    //                 {
    //                     check[nrow][ncol]=newCost;
    //                     q.add(new Tuple(newCost, nrow, ncol));
    //                 }
    //             }
    //         }
    //     }
    //     return check[grid.length-1][grid[0].length-1];
    // }

    public int minCost(int grid[][])
    {
        int n=grid.length;
        int m=grid[0].length;
        int check[][]=new int[n][m];
        for(var it:check)
            Arrays.fill(it,(int)1e9);
        Deque<Pair>q=new ArrayDeque<>();
        q.addFirst(new Pair(0, 0));
        check[0][0]=0;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        while(!q.isEmpty())
        {
            var node=q.pollFirst();
            var r=node.r;
            var c=node.c;
            for(int i=0;i<4;i++)
            {
                int nrow=r+delRow[i];
                int ncol=c+delCol[i];
                int cost=i+1==grid[nrow][ncol]?0:1;
                if(nrow<n && nrow>=0 && ncol>=0 && ncol<m)
                {
                    if(cost+check[r][c]<check[nrow][ncol])
                    {
                        check[nrow][ncol]=cost+check[r][c];

                        if(cost==1)
                            q.addLast(new Pair(nrow, ncol));
                        else
                            q.addFirst(new Pair(nrow, ncol));
                    }
                }
            }
        }
        return check[n-1][m-1];
    }
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

class Tuple
{
    int cost, row, col;

    Tuple(int cost, int row, int col)
    {
        this.cost=cost;
        this.row=row;
        this.col=col;
    }
}

