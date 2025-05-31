package dailyproblems.longestcommonsubsequenceproblems;

import java.util.Arrays;
import java.util.TreeMap;

public class TotalNumberOfLongestIncreasingSubSequence 
{
    public int findNumberOfLIS(int[] nums) {
        return solve(nums);
    }

    private int solve(int nums[])
    {
        int dp[]=new int[nums.length];
        int count[]=new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        int res=0, max=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i] && dp[i]<dp[j]+1)
                {
                    dp[i]=1+dp[j];
                    count[i]=count[j];
                }
                else if(nums[j]<nums[i] && dp[i]==dp[j]+1)
                    count[i]+=count[j];
            }
            max=Math.max(max, dp[i]);
        }

        for(int i=0;i<nums.length;i++)
        {
            if(dp[i]==max)
                res+=count[i];
        }
        return res;

    }

    public static void main(String[] args) {
        TotalNumberOfLongestIncreasingSubSequence totalNumberOfLongestIncreasingSubSequence=new TotalNumberOfLongestIncreasingSubSequence();
        int arr[]={1,3,5,4,7};
        System.out.println(totalNumberOfLongestIncreasingSubSequence.findNumberOfLIS(arr));
    }
}
