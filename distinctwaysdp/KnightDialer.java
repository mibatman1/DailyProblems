package dailyproblems.distinctwaysdp;

import java.util.Arrays;

// Need To Check Again
public class KnightDialer 
{
    int MOD = (int) 1e9 + 7;
    int ans=0;
    int[][] jumps = {
        {4, 6},
        {6, 8},
        {7, 9},
        {4, 8},
        {3, 9, 0},
        {},
        {1, 7, 0},
        {2, 6},
        {1, 3},
        {2, 4}
    };

    public int knightDialer(int n) 
    {
        int dp[][]=new int[n+1][10];
        for(var a:dp)
            Arrays.fill(a, -1);
        for(var i=0;i<10;i++)
        {
            ans=(ans+solve(n-1, i, dp))%MOD;
        }
        return ans;
    }

    private int solve(int n, int rem, int dp[][])
    {
        if(n==0)
            return 1;
        if(dp[n][rem]!=-1)
            return dp[n][rem];
        for(var it:jumps[rem])
        {
            ans=(ans+solve(n-1, it, dp))%MOD;
        }
        return dp[n][rem]=ans;
    }

    public static void main(String[] args) {
        KnightDialer knightDialer=new KnightDialer();
        int n=2;
        System.out.println(knightDialer.knightDialer(n));
    }
}
