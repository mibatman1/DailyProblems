package dailyproblems.minmaxdp;

import java.util.Arrays;

public class FindMaximalSquare 
{
    private int max=0;

    public int maximalSquare(char[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(var it:dp)
            Arrays.fill(it, -1);
        //solve(matrix, 0, 0);
        solve1(matrix, 0, 0, dp);
        return max*max;
    }

    // Recursion
    private int solve(char mat[][], int n, int m)
    {
        if(n>=mat.length || m>=mat[0].length)
            return 0;
        int right=solve(mat, n, m+1);
        int diagonal=solve(mat, n+1, m+1);
        int down=solve(mat, n+1, m);
        int ans=0;
        if(mat[n][m]=='1')
        {
            ans=1+Math.min(right, Math.min(diagonal, down));
            max=Math.max(max, ans);
        }
        else
        {
            return 0;
        }
        return ans;
    }

    // Recursion + DP
    private int solve1(char mat[][], int n, int m, int dp[][])
    {
        if(n>=mat.length || m>=mat[0].length)
        {
            return 0;
        }
        if(dp[n][m]!=-1)
            return dp[n][m];
        int right=solve1(mat, n, m+1, dp);
        int diag=solve1(mat, n+1, m+1, dp);
        int down=solve1(mat, n+1, m, dp);
        int ans=0;
        if(mat[n][m]=='1')
        {
            ans=1+Math.min(right, Math.min(diag, down));
            max=Math.max(max, ans);
        }
        else
        {
            return dp[n][m]=0;
        }
        return dp[n][m]=ans;
    }

    public static void main(String[] args) {
        FindMaximalSquare findMaximalSquare=new FindMaximalSquare();
        char mat[][]={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(findMaximalSquare.maximalSquare(mat));
    }
}
