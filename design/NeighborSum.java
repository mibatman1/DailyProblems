package design;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-neighbor-sum-service/description/?envType=problem-list-v2&envId=mbnk3qwv
public class NeighborSum {

    private int grid[][];
    private Map<Integer, Pair>mp;
    public NeighborSum(int[][] grid) {
        this.grid=grid;  
        mp=new HashMap<>();
        initialize(this.grid);     
    }
    
    public int adjacentSum(int value) {
        int ans=0;
        int delRow[]={-1, 0, 1, 0};
        int delCol[]={0, 1, 0, -1};
        var node=mp.get(value);
        for(int i=0;i<4;i++)
        {
            var nrow=node.row+delRow[i];
            var ncol=node.col+delCol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length)
            {
                ans+=this.grid[nrow][ncol];
            }
        }
        return ans;    
    }
    
    public int diagonalSum(int value) {
        int ans=0;
        int delRow[] = {-1, -1, 1, 1};
        int delCol[] = {-1, 1, 1, -1};
        var node=mp.get(value);
        for(int i=0;i<4;i++)
        {
            var nrow=node.row+delRow[i];
            var ncol=node.col+delCol[i];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length)
            {
                ans+=this.grid[nrow][ncol];
            }
        }
        return ans;
    }

    void initialize(int grid[][])
    {
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                mp.put(grid[i][j], new Pair(i, j));
            }
        }
    }

    class Pair
    {
        int row, col;
        Pair(int row, int col)
        {
            this.row=row;
            this.col=col;
        }
    }
}
