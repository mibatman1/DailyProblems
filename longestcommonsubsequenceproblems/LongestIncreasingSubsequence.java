package dailyproblems.longestcommonsubsequenceproblems;

import java.util.Arrays;

public class LongestIncreasingSubsequence 
{
    public int lengthOfLIS(int[] nums) 
    {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(var a:dp)
            Arrays.fill(a, -1);
        //return solve1(nums, 0, -1, dp);
        //return solve(nums, 0, -1);
        //return solve2(nums);
        return solve3(nums);
    }

    // Recursion
    private int solve(int nums[], int idx, int prev)
    {
        if(nums.length==idx)
            return 0;
        int notTake=solve(nums, idx+1, prev);
        if(prev==-1 || nums[idx]>nums[prev])
            notTake=Math.max(1+solve(nums, idx+1, idx),notTake);
        return notTake;
    }

    // Recursion + DP
    private int solve1(int nums[], int idx, int prev, int dp[][])
    {
        if(idx==nums.length)
            return 0;
        if(dp[idx][prev+1]!=-1)
            return dp[idx][prev+1];
        int notTake=solve1(nums, idx+1, prev, dp);
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev])
            take=1+solve1(nums, idx+1, idx, dp);
        return dp[idx][prev+1]=Math.max(notTake, take);
    }

    // Tabulation
    private int solve2(int nums[])
    {
        int dp[][]=new int[nums.length+1][nums.length+1];
        for(var it:dp)
            Arrays.fill(it, 0);
        for(int i=nums.length-1;i>=0;i--)
        {
            for(int j=i-1;j>=-1;j--)
            {
                int notTake=dp[i+1][j+1];
                int take=0;
                if(j==-1 || nums[i]>nums[j])
                    take=1+dp[i+1][i+1];
                dp[i][j+1]=Math.max(notTake, take);
            }
        }
        return dp[0][-1+1];
    }

    // Space Optimized
    private int solve3(int nums[])
    {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, 1);
        int max=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i]=Math.max(1+dp[j], dp[i]);
                }
            }
            max=Math.max(max, dp[i]);
        }
        for(var it:dp)
            System.out.print(it+" ");
        return max;
    }

    public static void main(String[] args) {
        int nums[]={1,3,5,4,7};
        LongestIncreasingSubsequence longestIncreasingSubsequence=new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(nums));
    }
    
}
