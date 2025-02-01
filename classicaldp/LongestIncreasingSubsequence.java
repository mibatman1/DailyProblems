package classicaldp;

import java.util.Arrays;

public class LongestIncreasingSubsequence 
{
    public int lengthOfLIS(int[] nums) 
    {
        int dp[][]=new int[nums.length][nums.length+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        return solve(nums, 0, -1, dp);
    }

    private int solve(int nums[], int idx, int pre, int dp[][])
    {
        if(idx==nums.length)
            return 0;
        if(dp[idx][pre+1]!=-1)
            return dp[idx][pre+1];
        int len=solve(nums, idx+1, pre, dp);
        if(pre==-1 || nums[idx]>nums[pre])
            len=Math.max(1+solve(nums, idx+1, idx, dp), len);
        return dp[idx][pre+1]=len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence=new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{1,3,5,4,7}));
    }
}
