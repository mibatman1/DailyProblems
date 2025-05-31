package dailyproblems.stdp;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChange 
{
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(coins, amount, coins.length-1);
        //return solve1(coins, amount, coins.length-1, dp);
        return solve2(coins, amount);
    }

    // Recursive
    private int solve(int coins[], int amount, int idx)
    {
        if(idx==0)
        {
            if(amount%coins[idx]==0)
            {
                return amount/coins[idx];
            }
            return (int)1e9;
        }
        int notTake=solve(coins, amount, idx-1);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=amount)
        {
            take=1+solve(coins, amount-coins[idx], idx);
        }
        return Math.min(notTake, take);
    }

    // Recursive + DP
    private int solve1(int coins[], int amount, int idx, int dp[][])
    {
        if(idx==0)
        {
            if(amount%coins[0]==0)
            {
                return amount/coins[0];
            }
            return (int)1e9;
        }
        if(dp[idx][amount]!=-1)
        {
            return dp[idx][amount];
        }
        int notPick=solve1(coins, amount, idx-1, dp);
        int pick=Integer.MAX_VALUE;
        if(coins[idx]<=amount)
        {
            pick=1+solve1(coins, amount-coins[idx], idx, dp);
        }
        return dp[idx][amount]=Math.min(notPick, pick);
    }

    // Tabulation(Bottom Up Approach)
    private int solve2(int coins[], int amount)
    {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<amount;i++)
        {
            if(i%coins[0]==0)
            {
                dp[0][i]=i/coins[0];
            }
            else
            {
                dp[0][i]=(int)1e9;
            }
        }
        for(int i=1;i<coins.length;i++)
        {
            for(int j=0;j<amount;j++)
            {
                int notPick=dp[i-1][j];
                int pick=Integer.MAX_VALUE;
                if(coins[i]<=amount)
                {
                    pick=1+dp[i][amount-coins[i]];
                }
                dp[i][j]=Math.min(notPick, pick);
            }
        }
        int ans=dp[coins.length-1][amount];
        if(ans>=(int)1e9)
            return -1;
        return ans;
    }


    public static void main(String[] args) {
        CoinChange coinChange=new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));
    }
}
