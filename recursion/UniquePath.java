package recursion;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/?envType=problem-list-v2&envId=mk7l73rc
public class UniquePath 
{
    public int uniquePaths(int m, int n) {
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(memo[i], -1);
        }
        return solve(m-1, n-1, memo);
    }

    int solve(int m, int n, int memo[][])
    {
        if(m==0 && n==0)
            return 1;
        if(m<0 || n<0)
            return 0;
        if(memo[m][n]!=-1)
            return memo[m][n];
        int right=solve(m-1, n, memo);
        int left=solve(m, n-1, memo);
        memo[m][n]=right+left;
        return memo[m][n];
    }

    public static void main(String[] args) {
        UniquePath uniquePath=new UniquePath();
        System.out.println(uniquePath.uniquePaths(3, 7));
    }
}
