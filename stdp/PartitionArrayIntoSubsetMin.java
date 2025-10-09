package dailyproblems.stdp;

import java.util.Arrays;

public class PartitionArrayIntoSubsetMin 
{
    public int minimumDifference(int[] nums) 
    {
        int sum=0;
        for(var i:nums)
            sum+=i;

        int dp[][]=new int[nums.length][sum];
        for(var d:dp)
            Arrays.fill(d, -1);

        solve1(nums, 0, sum, dp);
        int min=Integer.MIN_VALUE;
        for(var i=0;i<sum/2;i++)
        {
            if(dp[nums.length-1][i]==1)
            {
                min=Math.min(min, Math.abs((sum-i)-i));
            }
        }
        return min;
    }

    private boolean solve1(int nums[], int idx, int target, int dp[][])
    {
        if(target==0)
            return true;
        if(idx==0)
            return nums[idx]==target;
        if(dp[idx][target]!=-1)
            return dp[idx][target]==0?false:true;
        boolean take=false;
        if(nums[idx]<=target)
            take=solve1(nums, idx-1, target-nums[idx], dp);
        boolean notTake=solve1(nums, idx-1, target, dp);
        dp[idx][target]=take||notTake==true?1:0;
        return take||notTake;
    }
    
}
