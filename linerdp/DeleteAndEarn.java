package dailyproblems.linerdp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn 
{
    private Map<Integer, Integer>freq=new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        // int max=0;
        // for(var num:nums)
        // {
        //     max=Math.max(max, num);
        // }
        int dp[]=new int[nums.length+1];
        int freq[]=new int[nums.length+2];
        Arrays.fill(dp,-1);
        for(var it:nums)
        {
            freq[it]++;
        }
        return solve(nums, 0, dp);
    }

    int solve(int nums[], int idx, int dp[])
    {
        if(idx>=nums.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int take=nums[idx]+solve(nums, idx+2, dp);
        int notTake=solve(nums, idx+1, dp);
        return dp[idx]=Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int nums[]={3,4,2};
        DeleteAndEarn deleteAndEarn=new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }
}
