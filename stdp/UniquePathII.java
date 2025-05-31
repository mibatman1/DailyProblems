package dailyproblems.stdp;

import java.util.Arrays;

public class UniquePathII 
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int dp[][]=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
        //return solve1(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1, dp);
        return solve2(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    // Recursive
    private int solve(int obs[][], int n, int m)
    {
        if(n>=0 && m>=0 && obs[n][m]==1)
            return 0;
        if(n==0 && m==0)
            return 1;

        if(n<0 || m<0)
            return 0;
        int left=solve(obs, n-1, m);
        int right=solve(obs, n, m-1);
        return left+right;
    }

    // Recursive + DP
    private int solve1(int obs[][], int n, int m, int dp[][])
    {
        if(n>=0 && m>=0 && obs[n][m]==1)
            return 0;
        if(n==0 && m==0)
            return 1;
        if(n<0 || m<0)
            return 0;
        if(dp[n][m]!=-1)
            return dp[n][m];
        int up=solve1(obs, n-1, m, dp);
        int right=solve1(obs, n, m-1, dp);
        return dp[n][m]=right+up;
    }

    // Tabulation(Bottom Up)
    private int solve2(int obs[][], int n, int m)
    {
        int dp[][]=new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 && j==0)
                    continue;
                else if(obs[i][j]==1)
                    dp[i][j]=0;
                else
                {
                    int up=0, right=0;
                    if(i>0)
                        up=dp[i-1][j];
                    if(j>0)
                        right=dp[i][j-1];
                    dp[i][j]=up+right;
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int arr[][]={{0,0,0},{0,1,0},{0,0,0}};
        UniquePathII uniquePathII=new UniquePathII();
        System.out.println(uniquePathII.uniquePathsWithObstacles(arr));
    }
}
