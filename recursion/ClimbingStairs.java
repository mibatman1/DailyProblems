package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/climbing-stairs/?envType=problem-list-v2&envId=mk7l73rc
public class ClimbingStairs 
{
    public int climbStairs(int n) 
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    int solve(int n, int dp[])
    {
        if(n==0 || n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        dp[n]=solve(n-1, dp)+solve(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs=new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(45));
    }
}
