package linerdp;

import java.util.Arrays;

// https://leetcode.com/problems/perfect-squares/description/?envType=problem-list-v2&envId=m221lq9s
public class PerfectSquare 
{
    public int numSquares(int n) 
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    int solve(int n, int dp[])
    {
        if(n<=0)
        {
            return 0;
        }
        if(dp[n]!=-1)
            return dp[n];
        int ans=n;
        for(int i=1;i*i<=n;i++)
        {
            int sq=i*i;
            ans=Math.min(ans, 1+solve(n-sq, dp));
        }
        return dp[n]=ans;
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare=new PerfectSquare();
        System.out.println(perfectSquare.numSquares(12));
    }
}
