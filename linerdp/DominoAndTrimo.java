package dailyproblems.linerdp;

import java.util.Arrays;

public class DominoAndTrimo 
{
    private int mod=1000000007;
    public int numTilings(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        return solve1(n, dp);
        //return solve(n);
    }

    // Recursion
    private int solve(int n)
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 5;
        return (2*solve(n-1))%mod+(solve(n-3))%mod;
    }

    // Recursion + Memo
    private int solve1(int n, int dp[])
    {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 5;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=(2*solve1(n-1, dp))%mod+(solve1(n-3, dp))%mod;
    }

    public static void main(String[] args) {
        DominoAndTrimo dominoAndTrimo=new DominoAndTrimo();
        System.out.println(dominoAndTrimo.numTilings(30));
    }
    
}
