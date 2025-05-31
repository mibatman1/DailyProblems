package dailyproblems.distinctwaysdp;

import java.util.Arrays;

public class KnightProbabilityInChessboard 
{
    private int[][] directions = 
    {
        {1, 2}, {1, -2}, {-1, 2}, 
        {-1, -2}, {2, 1}, {2, -1}, 
        {-2, 1}, {-2, -1}
    };

    public double knightProbability(int n, int k, int row, int column) {
        double dp[][][]=new double[n+1][n+1][k+1];
        for(var it:dp)
            for(var it1:it)
                Arrays.fill(it1, -1);
        return solve(n, k, row, column, dp);
    }

    private double solve(int n, int k, int row, int col, double dp[][][])
    {
        if(row<0 || col<0 || row>=n || col>=n)
            return 0;
        if(k==0)
            return 1;
        if(dp[row][col][k]!=-1)
            return dp[row][col][k];
        double ans=0;
        for(var i=0;i<8;i++)
        {
            int nrow=row+directions[i][0];
            int ncol=col+directions[i][1];
            ans+=solve(n, k-1, nrow, ncol, dp)/8.0;
        }
        return dp[row][col][k]=ans;
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard knightProbabilityInChessboard=new KnightProbabilityInChessboard();
        int n=3, k=2, row=0, column=0;
        System.out.println(knightProbabilityInChessboard.knightProbability(n, k, row, column));
    }
    
}
