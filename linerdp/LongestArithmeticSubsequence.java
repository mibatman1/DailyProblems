package dailyproblems.linerdp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence 
{
    public int longestSubsequence(int[] arr, int difference) {
        int dp[][]=new int[arr.length+1][arr.length+1];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(arr, difference, 0, Integer.MIN_VALUE);
        //return solve1(arr, difference, 0, -1, dp);
        return solve2(arr, difference);
    }

    private int solve(int arr[], int diff, int idx, int prev)
    {
        if(idx>=arr.length)
        {
            return 0;
        }
        int notTake=solve(arr, diff, idx+1, prev);
        int take=Integer.MIN_VALUE;
        if(prev==Integer.MIN_VALUE || (arr[idx]-prev)==diff)
            take=1+solve(arr, diff, idx+1, arr[idx]);
        return Math.max(notTake, take);
    }

    // Recursion + DP
    private int solve1(int arr[], int diff, int idx, int prev, int dp[][])
    {
        if(idx>=arr.length)
        {
            return 0;
        }
        if(prev!=-1 && dp[idx][prev]!=-1)
        {
            return dp[idx][prev];
        }
        int notTake=solve(arr, diff, idx+1, prev);
        int take=Integer.MIN_VALUE;
        if(prev==-1 || (arr[idx]-prev)==diff)
            take=1+solve(arr, diff, idx+1, arr[idx]);
        return dp[idx][prev]=Math.max(notTake, take);
    }

    //Tabulation
    private int solve2(int arr[], int diff)
    {
        int res=1;
        Map<Integer, Integer>mp=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int num=arr[i];
            if(mp.containsKey(num-diff))
            {
                mp.put(num, mp.get(num-diff)+1);
            }
            else
            {
                mp.put(num, 1);
            }
            res=Math.max(res, mp.get(num));
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={1,5,7,8,5,3,4,2,1};
        int diff=-2;
        LongestArithmeticSubsequence longestArithmeticSubsequence=new LongestArithmeticSubsequence();
        System.out.println(longestArithmeticSubsequence.longestSubsequence(arr, diff));
    }
    
}
