package dailyproblems.stdp;

import java.util.Arrays;

public class FrogJump 
{
    public int frogJump(int n, int heights[])
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp, -1);
        //return solve(n-1, heights);
        //return solve1(n-1, heights, dp);
        //return solve2(n-1, heights);
        return solve3(n-1, heights);
    }

    // Recursive
    private int solve(int n, int arr[])
    {
        if(n==0)
            return 0;
        int step1=solve(n-1, arr)+Math.abs(arr[n]-arr[n-1]);
        int step2=Integer.MAX_VALUE;
        if(n>1)
        {
            step2=solve(n-2, arr)+Math.abs(arr[n]-arr[n-2]);
        }
        return Math.min(step1, step2);
    }

    // Recursive + DP
    private int solve1(int n, int arr[], int dp[])
    {
        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int step1=solve1(n-1, arr, dp)+Math.abs(arr[n]-arr[n-1]);
        int step2=Integer.MAX_VALUE;
        if(n>1)
            step2=solve1(n-2, arr, dp)+Math.abs(arr[n]-arr[n-2]);
        return dp[n]=Math.min(step1, step2);
    }

    // Tabulation(Bottom Up)
    private int solve2(int n, int arr[])
    {
        int dp[]=new int[n+1];
        // Base case from the recursion.
        dp[0]=0;
        for(int i=1;i<n;i++)
        {
            int step1=dp[i-1]+Math.abs(arr[i]-arr[i-1]);
            int step2=Integer.MAX_VALUE;
            if(i>1)
            {
                step2=dp[i-2]+Math.abs(arr[i]-arr[i-2]);
            }
            dp[i]=Math.min(step1, step2);
        }
        return dp[n-1];
    }

    // Tabulation + Space Optimization
    private int solve3(int n, int arr[])
    {
        int prev1=0, prev2=0;
        for(int i=1;i<n;i++)
        {
            int step1=prev1+Math.abs(arr[i]-arr[i-1]);
            int step2=Integer.MAX_VALUE;
            if(i>1)
            {
                step2=prev2+Math.abs(arr[i]-arr[i-2]);
            }
            int curr=Math.min(step1, step2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }



    public static void main(String[] args) {
        int arr[]={10, 20, 30, 10};
        FrogJump frogJump=new FrogJump();
        //System.out.println(frogJump.frogJump(4, arr));
        System.out.println(frogJump.frogJump(4, arr));
    }
    
}
