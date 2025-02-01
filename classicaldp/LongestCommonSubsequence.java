package classicaldp;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/description/?envType=problem-list-v2&envId=m22s5qzg
// Important
public class LongestCommonSubsequence 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int dp[][]=new int[text1.length()][text2.length()];
        for(var it:dp)
            Arrays.fill(it, -1);
        return solve(text1, text2, text1.length()-1, text2.length()-1, dp);
    }

    private int solve(String s1, String s2, int i, int j, int dp[][])
    {
        if(i<0 || j<0)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]= 1+solve(s1, s2, i-1, j-1, dp);
        return dp[i][j]=Math.max(solve(s1, s2, i-1, j, dp), solve(s1, s2, i, j-1, dp));
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence=new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("hello", "hel"));
    }
}
