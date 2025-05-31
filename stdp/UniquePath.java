package dailyproblems.stdp;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/description/
public class UniquePath 
{
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(m-1, n-1);
        //return solve1(m-1, n-1, dp);
        //return solve2(m, n);
        return solve3(m, n);

    }

    // Recursive
    private int solve(int m, int n)
    {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        int left=solve(m-1, n);
        int right=solve(m, n-1);
        return left+right;
    }

    // Recurive + DP
    private int solve1(int m, int n, int dp[][])
    {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        int left=solve1(m-1, n, dp);
        int right=solve1(m, n-1, dp);
        return dp[m][n]=right+left;
    }

    // Tabulation(Bottom Up approach)
    private int solve2(int m, int n)
    {
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    continue;
                int left=0, right=0;
                if(i>0)
                    left=dp[i-1][j];
                if(j>0)
                    right=dp[i][j-1];
                dp[i][j]=left+right;
            }
        }
        return dp[m-1][n-1];
    }

    // Tabulation + Space Optimization
    private int solve3(int m, int n)
    {
        int dp[]=new int[n];
        for(int i=0;i<m;i++)
        {
            int temp[]=new int[n];
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                    temp[j]=1;
                else
                {
                    int up=0, right=0;
                    if(i>0)
                    {
                        up=dp[j];
                    }
                    if(j>0)
                    {
                        right=temp[j-1];
                    }
                    temp[j]=right+up;
                }
            }
            dp=temp;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePath uniquePath=new UniquePath();
        System.out.println(uniquePath.uniquePaths(3, 7));
    }
}
