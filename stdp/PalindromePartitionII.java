package dailyproblems.stdp;

import java.util.Arrays;

// https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitionII 
{
    public int minCut(String s) {
        int dp[]=new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve1(0, s.length(), s, dp)-1;
        //return solve(0, s.length(), s)-1;
    }

    // Recursion
    private int solve(int i, int n, String s)
    {
        if(i==n)
            return 0;
        int minCost=Integer.MAX_VALUE;
        for(var j=i;j<n;j++)
        {
            if(isPalindome(i, j, s))
            {
                int cost=1+solve(j+1, n, s);
                minCost=Math.min(minCost, cost);
            }
        }
        return minCost;
    }

    // Recursion + Memoization
    private int solve1(int i, int n, String s, int dp[])
    {
        if(i==n)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int minCost=Integer.MAX_VALUE;
        for(var j=i;j<n;j++)
        {
            if(isPalindome(i, j, s))
            {
                int cost=1+solve(j+1, n, s);
                minCost=Math.min(minCost, cost);
            }
        }
        return dp[i]=minCost;
    }

    private boolean isPalindome(int i, int j, String s)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitionII palindromePartitionII=new PalindromePartitionII();
        String s="aab";
        System.out.println(palindromePartitionII.minCut(s));
    }
}
