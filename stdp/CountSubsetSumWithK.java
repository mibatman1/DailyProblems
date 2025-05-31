package dailyproblems.stdp;

import java.util.Arrays;

// https://www.naukri.com/code360/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
public class CountSubsetSumWithK {

    public int findWays(int num[], int tar) {
        int dp[][]=new int[num.length][tar+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve1(num.length-1, tar, num, dp);
        //return solve2(num, tar);
        return solve3(num, tar);
    }
    
    // Recursion
    private int solve(int idx, int tar, int nums[])
    {
        if(tar==0)
            return 1;
        if(idx==0)
            return nums[idx]==tar?1:0;
        int pick=0;
        if(nums[idx]<=tar)
            pick=solve(idx-1, tar-nums[idx], nums);
        int notPick=solve(idx-1, tar, nums);
        return notPick+pick;
    }

    // Recursion + DP
    private int solve1(int idx, int tar, int nums[], int dp[][])
    {
        if(idx==0)
            return nums[idx]==tar?1:0;
        if(tar==0)
            return 1;
        if(dp[idx][tar]!=-1)
            return dp[idx][tar];
        int pick=0;
        if(nums[idx]<=tar)
        {
            pick=solve1(idx-1, tar-nums[idx], nums, dp);
        }
        int notPick=solve1(idx-1, tar, nums, dp);
        return dp[idx][tar]=notPick+pick;
    }

    // Tabulation(Bottom Up)
    private int solve2(int nums[], int tar)
    {
        int dp[][]=new int[nums.length][tar+1];
        for(int i=0;i<nums.length;i++)
            dp[i][0]=1;
        if(nums[0]<=tar)
            dp[0][nums[0]]=1;
        for(int i=1;i<nums.length;i++)
        {
            for(int j=0;j<=tar;j++)
            {
                int notTake=dp[i-1][j];
                int take=0;
                if(nums[i]<=j)
                    take=dp[i-1][j-nums[i]];
                dp[i][j]=take+notTake;
            }
        }
        return dp[nums.length-1][tar];
    }

    // Tabulation + Space Opt
    private int solve3(int nums[], int tar)
    {
        int prev[]=new int[tar+1];
        int curr[]=new int[tar+1];
        prev[0]=1;
        if(nums[0]<=tar)
            curr[nums[0]]=1;
        for(int i=1;i<nums.length;i++)
        {
            for(int sum=0;sum<=tar;sum++)
            {
                int pick=0;
                int notPick=prev[sum];
                if(nums[i]<=sum)
                    pick=prev[sum-nums[i]];
                curr[sum]=notPick+pick;
            }
            prev=curr;
        }
        return prev[tar];
    }

    public static void main(String[] args) {
        int arr[]={1, 4, 4, 5};
        CountSubsetSumWithK countSubsetSumWithK=new CountSubsetSumWithK();
        System.out.println(countSubsetSumWithK.findWays(arr, 5));
    }
}
