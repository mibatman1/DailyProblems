package dailyproblems.dp;

import java.util.Arrays;
import java.util.List;

public class MaxSumAdj 
{
    static int f(int n, List<Integer> nums,int dp[])
    {
        if(n==0)
        {
            return nums.get(0);
        }
        if(n<0)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        int pick=nums.get(n)+f(n-2, nums,dp);
        int notPick=nums.get(n)+f(n-1,nums,dp);
        return dp[n]= Math.max(pick, notPick);
    }

    public static int maximumNonAdjacentSum(List<Integer> nums)
    {
        int n=nums.size();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
    public static void main(String[] args) 
    {
        List<Integer>nums=Arrays.asList(1,2,3,5,4);
        System.out.println(maximumNonAdjacentSum(nums));
    }
}
