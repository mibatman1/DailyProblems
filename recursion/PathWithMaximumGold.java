package recursion;

// https://leetcode.com/problems/path-with-maximum-gold/description/?envType=problem-list-v2&envId=mk7dslmg
public class PathWithMaximumGold 
{
    public int getMaximumGold(int[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    res=Math.max(res,solve(grid, i, j));
                }
            }
        }
        return res;  
    }

    int solve(int grid[][], int i, int j)
    {
        int n=grid.length;
        int m=grid[0].length;
        int val=grid[i][j];
        int curr=val;
        grid[i][j]=0;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        for(int k=0;k<4;k++)
        {
            int rrow=i+delRow[k];
            int ccol=j+delCol[k];
            if(rrow<n && rrow>=0 && ccol<m && ccol>=0 && grid[rrow][ccol]!=0)
            {
                curr=Math.max(curr, val+solve(grid, rrow, ccol));
            }
        }
        grid[i][j]=val;
        return curr;
    }


    public static void main(String[] args) {
        int arr[][]={{0,6,0},{5,8,7},{0,9,0}};
        PathWithMaximumGold pathWithMaximumGold=new PathWithMaximumGold();
        System.out.println(pathWithMaximumGold.getMaximumGold(arr));
    }
}
