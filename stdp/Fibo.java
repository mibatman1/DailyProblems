package dailyproblems.stdp;

public class Fibo 
{
    // Recursive DP.(Top Down Approach)
    private int f(int n, int dp[])
    {
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=f(n-1, dp)+f(n-2, dp);
    }

    // Tabulation Approach. (Bottom Up)
    private int f1(int n, int dp[])
    {
        //Base case
        dp[0]=0;
        dp[1]=1;
        for(int i=2; i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // Tabulation + Space Optimization
    private int f2(int n)
    {
        int prev1=1, prev2=0;
        for(int i=2;i<=n;i++)
        {
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
