package dailyproblems.stdp;

import java.util.Arrays;

public class RodCutting 
{
    public int cutRod(int[] price) {
        int dp[][]=new int[price.length][price.length+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(price.length-1, price, price.length);
        return solve1(price.length-1, price, price.length, dp);
    }

    // Recursion
    private int solve(int idx, int price[], int length)
    {
        if(idx==0)
        {
            return length*price[0];
        }
        int notTake=solve(idx-1, price, length);
        int take=Integer.MIN_VALUE;
        int rodLength=idx+1;
        if(length>=rodLength)
        {
            take=price[idx]+solve(idx-1, price, length-rodLength);
        }
        return Math.max(take, notTake);
    }

    // Recursion + DP
    private int solve1(int idx, int price[], int length, int dp[][])
    {
        if(idx==0)
        {
            return length*price[0];
        }
        if(dp[idx][length]!=-1)
        {
            return dp[idx][length];
        }
        int notTake=solve1(idx-1, price, length, dp);
        int take=Integer.MIN_VALUE;
        int rodLen=idx+1;
        if(length>=rodLen)
            take=price[idx]+solve1(idx, price, length-rodLen, dp);
        return dp[idx][length]=Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int arr[]={1, 5, 8, 9, 10, 17, 17, 20};
        RodCutting rodCutting=new RodCutting();
        System.out.println(rodCutting.cutRod(arr));    
    }
}
