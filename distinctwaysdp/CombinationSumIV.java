package dailyproblems.distinctwaysdp;

import java.util.Arrays;

public class CombinationSumIV 
{
    public int combinationSum4(int[] nums, int target) {
        int dp[]=new int[target+1];
        Arrays.fill(dp, -1);
        return solve1(nums, target, dp);   
    }

    // Recursion
    private int solve(int nums[], int target)
    {
        if(target==0)
            return 1;
        if(target<0)
            return 0;
        int combination=0;
        for(int i=0;i<nums.length;i++)
        {
            combination+=solve(nums, target-nums[i]);
        }
        return combination;
    }

    //Recursion + DP
    private int solve1(int nums[], int target, int dp[])
    {
        if(target==0)
            return 1;
        if(target<0)
            return 0;
        if(dp[target]!=-1)
            return dp[target];
        int combination=0;
        for(int i=0;i<nums.length;i++)
        {
            combination+=solve1(nums, target-nums[i], dp);
        }
        return dp[target]=combination;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        int target=4;
        CombinationSumIV combinationSumIV=new CombinationSumIV();
        System.out.println(combinationSumIV.combinationSum4(arr, target));
    }
}
