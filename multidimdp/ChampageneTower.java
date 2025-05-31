package dailyproblems.multidimdp;

// https://leetcode.com/problems/champagne-tower/description/?envType=problem-list-v2&envId=m221jeds
public class ChampageneTower 
{
    public double champagneTower(int poured, int query_row, int query_glass) 
    {
        double dp[][]=new double[101][101];
        dp[0][0]=(double)poured;
        for(int i=0;i<100;i++)
        {
            for(int j=i;j<=i;j++)
            {
                if(dp[i][j]>=1)
                {
                    dp[i+1][j]+=(dp[i][j]-1)/2;
                    dp[i+1][j+1]+=(dp[i][j]-1)/2;
                    dp[i][j]=1;
                }
            }
        }
        return dp[query_row][query_glass];    
    }

    public static void main(String[] args) 
    {

    }
}
