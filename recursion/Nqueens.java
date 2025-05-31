package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens
{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        int check[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(check[i], -1);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(check[i][j]==-1)
                {
                    solve(ans, n, check, i, j);
                }
            }
        }
        return ans;
    }

    void solve(List<List<String>>ans, int n, int check[][], int r, int c)
    {
        
    }
}
