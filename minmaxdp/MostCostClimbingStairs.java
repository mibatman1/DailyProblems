package dailyproblems.minmaxdp;

import java.util.Arrays;

public class MostCostClimbingStairs 
{
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(solve1(cost, cost.length-1, dp), solve1(cost, cost.length-2, dp));
        //return Math.min(solve(cost, cost.length-1), solve(cost, cost.length-2));
    }

    // Recursion
    private int solve(int cost[], int n)
    {
        if(n<0)
            return 0;
        if(n==0 || n==1)
            return cost[n];
        return cost[n]+Math.min(solve(cost, n-1), solve(cost, n-2));
    }

    // Recursion + DP
    private int solve1(int cost[], int n, int dp[])
    {
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        if(n==0 || n==1)
            return cost[n];
        return dp[n]=cost[n]+Math.min(solve1(cost, n-1, dp), solve1(cost, n-2, dp));
    }

    public static void main(String[] args) {
        MostCostClimbingStairs mostCostClimbingStairs=new MostCostClimbingStairs();
        int cost[]={10,15,20};
        System.out.println(mostCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
