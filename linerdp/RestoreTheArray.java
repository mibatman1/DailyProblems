package dailyproblems.linerdp;

import java.util.Arrays;

public class RestoreTheArray 
{
    public int numberOfArrays(String s, int k) 
    {
        int dp[]=new int[s.length()];
        Arrays.fill(dp, -1);
        return solve1(0, s, k, s.length(), dp);
        //return solve(0, s, k, s.length());
    }

    // Recursive
    private int solve(int start, String s, int k, int n)
    {
        if(start==n)
            return 1;
        if(s.charAt(start)=='0')
            return 0;
        
        int ans=0;
        long num=0;
        for(int end=start;end<s.length();end++)
        {
            num=(num*10)+s.charAt(end)-'0';
            if(num>k)
                break;
            ans=ans+solve(end+1, s, k, n);
        }
        return ans;
    }

    // Recursive + Memoization
    private int solve1(int i, String s, int k, int n, int dp[])
    {
        if(i==n)
            return 1;
        if(s.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int ans=0;
        long num=0;
        for(int j=i;j<n;j++)
        {
            num=(num*10)+s.charAt(i)-'0';
            if(num>k)
                break;
            ans+=solve1(j+1, s, k, n, dp);
        }
        return dp[i]=ans;
    }

    // Tabulation
    private int solve2(String s, int k)
    {
        
    }

    public static void main(String[] args) {
        String s="1317";
        int n=2000;
        RestoreTheArray restoreTheArray=new RestoreTheArray();
        System.out.println(restoreTheArray.numberOfArrays(s, n));
    }
}
