package dailyproblems.linerdp;

import java.util.Arrays;

// https://leetcode.com/problems/student-attendance-record-ii/?envType=problem-list-v2&envId=m221lq9s
public class StudentRecordII 
{
    private int mod=1000000007;
    public int checkRecord(int n) 
    {
        int dp[][][]=new int[n+1][2][3];
        for(var it:dp)
            for(var i:it)
                Arrays.fill(i, -1);
        return solve1(n, 0, 0, dp);
    }

    // Recursive
    int solve(int n, int a, int l)
    {
        if(a>=2 || l>=3)
            return 0;
        if(n==0)
            return 1;
        int count=0;
        count=(solve(n-1, a, 0))%mod;
        count=(count+solve(n-1, a+1, 0))%mod;
        count=(count+solve(n-1, a, l+1))%mod;
        return count;
    }

    // Recursive + DP
    int solve1(int n, int a, int l, int dp[][][])
    {
        if(a>=2 || l>=3)
            return 0;
        if(n==0)
            return 1;
        if(dp[n][a][l]!=-1)
            return dp[n][a][l];
        int count=0;
        count=(solve(n-1, a, 0))%mod;
        count=(count+solve(n-1, a+1, 0))%mod;
        count=(count+solve(n-1, a, l+1))%mod;
        return count;
    }
}
