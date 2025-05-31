package dailyproblems.distinctwaysdp;

import java.util.Arrays;

public class OutOfBoundaryPath 
{
    //private int ans=0;
    private int MOD=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][]=new int[m+1][n+1][maxMove+1];
        for(var it:dp)
            for(var it1:it)
                Arrays.fill(it1, -1);
        return solve(m, n, startRow, startColumn, maxMove, dp);
    }

    private int solve(int m, int n, int startRow, int startColumn, int maxMove, int dp[][][])
    {
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        if(startRow<0 || startColumn<0 || startRow>=m || startColumn>=n)
            return 1;
        if(maxMove<=0)
            return 0;
        if(dp[startRow][startColumn][maxMove]!=-1)
            return dp[startRow][startColumn][maxMove];
        int ans=0;
        for(var i=0;i<4;i++)
        {
            int nstartRow=startRow+delRow[i];
            int nstartColumn=startColumn+delCol[i];
            ans=(ans+solve(m, n, nstartRow, nstartColumn, maxMove-1, dp))%MOD;
        }
        return dp[startRow][startColumn][maxMove]=ans;
    }

    public static void main(String[] args) {
        OutOfBoundaryPath outOfBoundaryPath=new OutOfBoundaryPath();
        int m=1, n=3, maxMove=3, startRow=0, startColumn=1;
        System.out.println(outOfBoundaryPath.findPaths(m, n, maxMove, startRow, startColumn));
    }
}
