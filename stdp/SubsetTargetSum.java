package dailyproblems.stdp;

import java.util.Arrays;

public class SubsetTargetSum 
{
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(var it:nums)
            totalSum+=it;
        if(totalSum%2!=0)
            return false;
        int dp[][]=new int[nums.length][(totalSum/2)+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        return solve1(nums, nums.length-1, totalSum/2, dp);
    }

    // Recursive
    private boolean solve(int nums[], int idx, int target)
    {
        if(target==0)
            return true;
        if(idx==0)
            return nums[idx]==target;
        boolean pick=false;
        if(nums[idx]<=target)
            pick=solve(nums, idx-1, target-nums[idx]);
        boolean notPick=solve(nums, idx-1, target);
        return notPick || pick;
    }

    // Recursive + DP
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

    // Tabulation
    private boolean solve2(int nums[], int idx, int target)
    {
        boolean dp[][]=new boolean[idx][target+1];
        for(int i=0;i<idx;i++)
            dp[i][0]=true;
        if(nums[0]<=target)
            dp[0][nums[0]]=true;
        for(int i=1;i<idx;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean notTake=dp[i-1][target];
                boolean take=false;
                if(nums[idx]<=target)
                    take=dp[i-1][target-nums[i]];
                dp[i][target]=take||notTake;

            }
        }
        return dp[idx-1][target];
    }

    public static void main(String[] args) {
        int arr[]={1,5,11,5};
        SubsetTargetSum subsetTargetSum=new SubsetTargetSum();
        System.out.println(subsetTargetSum.canPartition(arr));
    }
}
