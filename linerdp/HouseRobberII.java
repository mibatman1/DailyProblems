package dailyproblems.linerdp;

import java.util.Arrays;

public class HouseRobberII 
{
    public int rob(int[] nums) 
    {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length-1, dp);   
    }
    int solve(int nums[], int idx, int dp[])
    {
        if(idx<=0)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int even=nums[idx]+solve(nums, idx-2, dp);
        int odd=solve(nums, idx-1, dp);
        return dp[idx]=Math.max(even, odd);
    }
}
