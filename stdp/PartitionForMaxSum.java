package dailyproblems.stdp;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-for-maximum-sum/
public class PartitionForMaxSum 
{
    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp, -1);
        return solve1(0, arr, k, dp);
        //return solve(0, arr, k);
    }
    
    // Recursion
    private int solve(int idx, int arr[], int k)
    {
        if(idx==arr.length)
            return 0;
        int max=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        int len=0;
        for(int i=idx;i<Math.min(idx+k, arr.length);i++)
        {
            len++;
            max=Math.max(max, arr[i]);
            int sum=(len*max)+solve(i+1, arr, k);
            maxAns=Math.max(maxAns, sum);
        }
        return maxAns;
    }

    // Recursion + Memoization
    private int solve1(int idx, int arr[], int k, int dp[])
    {
        if(idx==arr.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int len=0;
        int max=Integer.MIN_VALUE;
        int maxAns=Integer.MIN_VALUE;
        for(int i=idx;i<Math.min(idx+k, arr.length);i++)
        {
            len++;
            max=Math.max(max, arr[i]);
            int sum=(max*len)+solve1(i+1, arr, k, dp);
            maxAns=Math.max(maxAns, sum);
        }
        return dp[idx]=maxAns;
    }

    public static void main(String[] args) {
        PartitionForMaxSum partitionForMaxSum=new PartitionForMaxSum();
        int arr[]={1,15,7,9,2,5,10};
        int k=3;
        System.out.println(partitionForMaxSum.maxSumAfterPartitioning(arr, k));
    }
}
