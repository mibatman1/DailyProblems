package dailyproblems.linerdp;

import java.util.Arrays;

public class HouseRobber 
{
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length-1, dp);
    }

    int solve(int nums[], int idx, int dp[])
    {
        if(idx<0)
        {
            return 0;
        }
        if(dp[idx]!=-1)
            return dp[idx];
        int even=nums[idx]+solve(nums, idx-2, dp);
        int odd=solve(nums, idx-1, dp);
        return dp[idx]=Math.max(even, odd);
    }

    public static void main(String[] args) {
        int arr[]={114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        HouseRobber houseRobber=new HouseRobber();
        System.out.println(houseRobber.rob(arr));
    }
}
