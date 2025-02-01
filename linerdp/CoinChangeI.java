package linerdp;

// https://leetcode.com/problems/coin-change/?envType=problem-list-v2&envId=m221lq9s
public class CoinChangeI 
{
    public int coinChange(int[] coins, int amount) 
    {
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        int ans=Integer.MAX_VALUE;
        for(var coin:coins)
        {
            int s=coinChange(coins, amount-coin);
            if(s>=0 && s<ans)
                ans=1+s;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    int solve(int coins[], int amount, int dp[])
    {
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(dp[amount]!=-2)
            return dp[amount];
        int ans=Integer.MAX_VALUE;
        for(var coin:coins)
        {
            int minCoin=solve(coins, amount-coin, dp);
            if(minCoin>=0 && minCoin<ans)
            {
                ans=1+minCoin;
            }
        }
        return dp[amount]=ans==Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,5};
        CoinChangeI changeI=new CoinChangeI();
        System.out.println(changeI.coinChange(arr, 11));
    }
}
