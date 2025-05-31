package dailyproblems.minmaxdp;

import java.util.Arrays;

public class OnesAndZeros 
{
    public int findMaxForm(String[] strs, int m, int n) 
    {
        int dp[][][]=new int[m+1][n+1][strs.length+1];
        for(var it:dp)
            for(var i:it)
                Arrays.fill(i, -1);
        return solve1(strs, m, n, 0, dp);
                //return solve(strs, m, n, 0);
    }

    private int solve(String strs[], int m, int n, int idx)
    {
        if(idx>strs.length-1)
            return 0;
        if(m<0 || n<0)
            return 0;
        if(m==0 && n==0)
            return 0;
        int ones=calc(strs[idx].toCharArray(),'1');
        int zeros=strs[idx].length()-ones;
        if(ones<=n && zeros<=m)
        {
           return Math.max(1+solve(strs, m-zeros, n-ones, idx+1), solve(strs, m, n, idx+1));
        }
        else
            return solve(strs, m, n, idx+1);
    }

    private int solve1(String strs[], int m, int n, int idx, int dp[][][])
    {
        if(idx>strs.length-1)
            return 0;
        if(m<0 || n<0)
            return 0;
        if(m==0 && n==0)
            return 0;
        if(dp[m][n][idx]!=-1)
            return dp[m][n][idx];
        int ones=calc(strs[idx].toCharArray(), '1');
        int zeros=strs[idx].length()-ones;
        if(ones<=n && zeros<=m)
            return dp[m][n][idx]=Math.max(1+solve1(strs, m-zeros, n-ones, idx+1, dp), solve1(strs, m, n, idx+1, dp));
        else
            return dp[m][n][idx]=solve1(strs, m, n, idx+1, dp);
    }

    private int calc(char ch[], char c)
    {
        int cnt=0;
        for(var a:ch)
        {
            if(a==c)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        OnesAndZeros onesAndZeros=new OnesAndZeros();
        String arr[]={"10","0001","111001","1","0"};
        int m=5, n=3;
        System.out.println(onesAndZeros.findMaxForm(arr, m, n));
    }
}
