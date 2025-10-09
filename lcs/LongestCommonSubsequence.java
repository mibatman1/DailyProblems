package dailyproblems.lcs;

public class LongestCommonSubsequence 
{
    public int longestCommonSubsequence(String text1, String text2) {
        return solve3(text1, text2);
        //return solve(text1, text2, 0, 0);
    }
    
    // Recursion
    private int solve(String s, String s1, int i, int j)
    {
        if(i>=s.length() || j>=s1.length())
            return 0;
        if(s.charAt(i)==s.charAt(j))
            return 1+solve(s, s1, i+1, j+1);
        return Math.max(solve(s, s1, i+1, j), solve(s, s1, i, j+1));
    }

    // Recursion+Memoization

    private int solve1(String s, String s1, int i, int j, int dp[][])
    {
        if(i>=s.length() || j>=s1.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==s1.charAt(j))
            return dp[i][j]=1+solve1(s, s1, i+1, j+1, dp);
        return dp[i][j]=Math.max(solve1(s, s1, i+1, j, dp), solve1(s, s1, i, j+1, dp));
    }

    //
    private int solve3(String s, String s1)
    {
        int n=s.length();
        int m=s1.length();

        int dp[][]=new int[n+1][m+1];

        for(var i=1;i<=n;i++)
        {
            for(var j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==s1.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);       
            }
        }
        // Print DP matrix
        for(var i=0; i<=n; i++) {
            for(var j=0; j<=m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();  // New line after each row
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s="cab";
        String s1="abac";
        LongestCommonSubsequence longestCommonSubsequence=new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.solve3(s, s1));
    }
}
