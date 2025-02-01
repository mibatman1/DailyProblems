package linerdp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn 
{
    private Map<Integer, Integer>freq=new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, -1);
        for(var it:nums)
            freq.put(it, freq.getOrDefault(it, 0)+1);
        //System.out.println(freq);
        return solve(nums, nums.length-1, dp);
    }

    int solve(int nums[], int idx, int dp[])
    {
        if(idx<=0)
            return 0;
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        System.out.println(freq.get(nums[idx]));
        int even=freq.get(nums[idx])*nums[idx]+solve(nums, idx-2, dp);
        int odd=solve(nums, idx-1, dp);
        return dp[idx]=Math.max(even, odd);
    }

    public static void main(String[] args) {
        int nums[]={2,2,3,3,3,4};
        DeleteAndEarn deleteAndEarn=new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }
}
