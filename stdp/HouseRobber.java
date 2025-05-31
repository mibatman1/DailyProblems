package dailyproblems.stdp;

import java.util.Arrays;

public class HouseRobber 
{
    public int rob(int[] nums) 
    {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp, -1);
        //return solve(nums, nums.length-1);
        //return solve1(nums, nums.length-1, dp);
        //return solve2(nums);
        return solve3(nums);
    }

    // Recursive
    private int solve(int arr[], int idx)
    {
        if(idx==0)
            return arr[0];
        if(idx<0)
            return 0;
        int pick=arr[idx]+solve(arr, idx-2);
        int notPick=solve(arr, idx-1);
        return Math.max(pick, notPick);
    }

    // Recursive + DP
    private int solve1(int arr[], int idx, int dp[])
    {
        if(idx==0)
            return arr[0];
        if(idx<0)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int pick=solve1(arr, idx-2, dp)+arr[idx];
        int notPick=solve1(arr, idx-1, dp);
        return dp[idx]=Math.max(pick, notPick);
    }

    // Tabulation (bottom up)
    private int solve2(int arr[])
    {
        System.out.println("This is tabulation approach");
        int dp[]=new int[arr.length+1];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int pick=0;
            if(i>1)
                pick=arr[i]+dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick, notPick);
        }
        return dp[arr.length-1];
    }

    // Tabulation + Space optimization
    private int solve3(int arr[])
    {
        System.out.println("This is tabulation and Space opt");
        int prev1=arr[0];
        int prev2=0;
        for(int i=1;i<arr.length;i++)
        {
            int take=0;
            if(i>1)
                take=arr[i]+prev2;
            int notTake=prev1;
            int curr=Math.max(take, notTake);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int arr[]={2,7,9,3,1};
        HouseRobber houseRobber=new HouseRobber();
        System.out.println(houseRobber.rob(arr));
    }
}
