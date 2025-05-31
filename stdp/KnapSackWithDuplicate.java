package dailyproblems.stdp;

import java.util.Arrays;

public class KnapSackWithDuplicate 
{
    private int knapSack(int val[], int wt[], int capacity) 
    {
        int dp[][]=new int[val.length][capacity+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(val, wt, capacity, val.length-1);
        return solve1(val, wt, capacity, val.length-1, dp);
    }

    private int solve(int val[], int wt[], int capacity, int idx)
    {
        if(idx==0)
        {
            return (capacity/wt[0])*val[0];
        }
        int notPick=solve(val, wt, capacity, idx-1);
        int pick=Integer.MIN_VALUE;
        if(wt[idx]>=capacity)
        {
            pick=1+solve(val, wt, wt[idx]-capacity, idx);
        }
        return Math.max(notPick, pick);
    }

    // Recursive + DP
    private int solve1(int val[], int wt[], int capacity, int idx, int dp[][])
    {
        if(idx==0)
        {
            return (capacity/wt[0])*val[0];
        }
        if(dp[idx][capacity]!=-1)
        {
            return dp[idx][capacity];
        }
        int notPick=solve1(val, wt, capacity, idx-1, dp);
        int pick=Integer.MIN_VALUE;
        if(wt[idx]>=capacity)
        {
            pick=1+solve1(val, wt, wt[idx]-capacity, idx, dp);
        }
        return dp[idx][capacity]=Math.max(notPick, pick);
    }

    // Tabulation(Bottom Up Approach)
    private int solve2(int val[], int wt[], int capacity)
    {
        int dp[][]=new int[val.length][capacity+1];
        for(int i=0;i<val.length;i++)
        {
            dp[0][capacity]=(capacity/wt[0])*val[0];
        }
        for(int i=1;i<)
    }

    public static void main(String[] args) {
        int arr[]={6, 1, 7, 7};
        int arr1[]={1, 3, 4, 5};
        int s=8;
        KnapSackWithDuplicate knapSackWithDuplicate=new KnapSackWithDuplicate();
        System.out.println(knapSackWithDuplicate.knapSack(arr, arr1, s));
    }
}
