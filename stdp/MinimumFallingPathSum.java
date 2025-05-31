package dailyproblems.stdp;

public class MinimumFallingPathSum 
{
    public int minFallingPathSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int dp[][]=new int[matrix.length][matrix[0].length];
        // for(int j=0;j<matrix[0].length;j++)
        // {
        //     min=Math.min(min, solve1(matrix.length-1, j, matrix, dp));
        // }
        //return min;
        //return solve(matrix.length-1, matrix[0].length-1, matrix);
        return solve2(matrix);
    }

    // Recursive
    private int solve(int i, int j, int matrix[][])
    {
        if(j<0 || j>=matrix[0].length)
            return (int)1e9;
        if(i==0)
            return matrix[0][j];
        int up=matrix[i][j]+solve(i-1, j, matrix);
        int left=matrix[i][j]+solve(i-1, j-1, matrix);
        int right=matrix[i][j]+solve(i-1, j+1, matrix);
        return Math.min(up, Math.min(left, right));
    }

    // Recursive + DP
    private int solve1(int i, int j, int matrix[][], int dp[][])
    {
        if(j<0 || j>=matrix[0].length)
            return (int)1e9;
        if(i==0)
            return matrix[i][j];
        if(dp[i][j]!=-1)
            return dp[i][j];
        int up=matrix[i][j]+solve1(i-1, j, matrix, dp);
        int left=matrix[i][j]+solve1(i-1, j-1, matrix, dp);
        int right=matrix[i][j]+solve1(i-1, j+1, matrix, dp);
        return dp[i][j]=Math.min(up, Math.min(left, right));
    }

    // Tabulation (Bottom Up)
    private int solve2(int matrix[][])
    {
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++)
        {
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];
                int left=matrix[i][j];
                if(j-1>=0)
                    left+=dp[i-1][j-1];
                else
                    left+=(int)1e9;
                int right=matrix[i][j];
                if(j+1<matrix[0].length)
                    right+=dp[i-1][j+1];
                else
                    right+=(int)1e9;
                dp[i][j]=Math.min(up, Math.min(left, right));
            }
        }
        int max=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
        {
            max=Math.min(max, dp[matrix.length-1][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[][]={{2,1,3},{6,5,4},{7,8,9}};
        MinimumFallingPathSum minimumFallingPathSum=new MinimumFallingPathSum();
        System.out.println(minimumFallingPathSum.minFallingPathSum(arr));
    }
    
}
