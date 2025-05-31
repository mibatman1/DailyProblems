package dailyproblems.griddp;

import java.util.Arrays;

public class MinPathSum 
{
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(var it:dp)
            Arrays.fill(it, -1);
        return solve1(grid, grid.length-1, grid[0].length-1, dp);
        //return solve(grid, grid.length-1, grid[0].length-1);
    }
    
    // Recursion
    private int solve(int arr[][], int i, int j)
    {
        if(i==0 && j==0)
            return arr[0][0];
        if(i<0 || j<0)
            return 10000000;
        int right=arr[i][j]+solve(arr, i, j-1);
        int down=arr[i][j]+solve(arr, i-1, j);
        return Math.min(right, down);
    }

    // Recursion + DP
    private int solve1(int arr[][], int i, int j, int dp[][])
    {
        if(i==0 && j==0)
            return arr[0][0];
        if(i<0 || j<0)
            return 1000000;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int right=arr[i][j]+solve1(arr, i, j-1, dp);
        int down=arr[i][j]+solve1(arr, i-1, j, dp);
        return dp[i][j]=Math.min(right, down);
    }

    public static void main(String[] args) {
        MinPathSum minPathSum=new MinPathSum();
        int arr[][]={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum.minPathSum(arr));
    }
}
