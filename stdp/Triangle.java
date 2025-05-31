package dailyproblems.stdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle/description/
public class Triangle 
{
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()+1][triangle.size()+1];
        for(var it: dp)
            Arrays.fill(it, -1);
        //return solve(0, 0, triangle);
        //return solve1(0, 0, triangle, dp);
        return solve2(triangle.size(), triangle);
    }

    // Recursion
    private int solve(int n, int m, List<List<Integer>>ls)
    {
        if(n==ls.size()-1)
            return ls.get(n).get(m);
        int down=ls.get(n).get(m)+solve(n+1, m, ls);
        int diag=ls.get(n).get(m)+solve(n+1, m+1, ls);
        return Math.min(diag, down);
    }

    // Recursion + DP
    private int solve1(int n, int m, List<List<Integer>>ls, int dp[][])
    {
        if(n==ls.size()-1)
            return ls.get(n).get(m);
        if(dp[n][m]!=-1)
            return dp[n][m];
        int down=ls.get(n).get(m)+solve1(n+1, m, ls, dp);
        int diag=ls.get(n).get(m)+solve1(n+1, m+1, ls, dp);
        return dp[n][m]=Math.min(diag, down);
    }

    // Tabulation(Bottom Up)
    private int solve2(int n, List<List<Integer>>ls)
    {
        int dp[][]=new int[ls.size()][ls.size()];
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=ls.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down=ls.get(i).get(j)+dp[i+1][j];
                int diag=ls.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(down, diag);       
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> arrayList = new ArrayList<>();
        arrayList.add(Arrays.asList(2));
        arrayList.add(Arrays.asList(3, 4));
        arrayList.add(Arrays.asList(6, 5, 7));
        arrayList.add(Arrays.asList(4, 1, 8, 3));
        Triangle triangle=new Triangle();
        System.out.println(triangle.minimumTotal(arrayList));
    }
    
}
