package dailyproblems.stdp;

public class PartitionArrayIntoSubsetMin 
{
    public int minimumDifference(int[] nums) 
    {
        int totalSum=0;
        for(var it:nums)
            totalSum+=it;
        int target=totalSum;
        boolean dp[][]=new boolean[nums.length][totalSum+1];
        for(int i=0;i<nums.length;i++)
            dp[i][0]=true;
        if(nums[0]<=target)
            dp[0][nums[0]]=true;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=target)
                    take=dp[i-1][target-nums[i]];
                dp[i][target]=take||notTake;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int s1=0;s1<totalSum/2;s1++)
        {
            if(dp[nums.length-1][s1]==true)
                min=Math.min(min, Math.abs((totalSum-s1)-s1));
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
