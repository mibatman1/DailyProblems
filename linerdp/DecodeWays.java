package dailyproblems.linerdp;

public class DecodeWays 
{
    public int numDecodings(String s) 
    {
        return solve(s, 0);
    }

    // Recursion
    private int solve(String s, int idx)
    {
        if(idx==s.length())
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        int take=solve(s, idx+1);
        if(idx+1<s.length() && Integer.parseInt(s.substring(idx, idx+2))<=26)
            take+=solve(s, idx+2);
        return take;
    }

    // Recursion + Memo
    private int solve1(String s, int idx, int dp[])
    {
        if(idx==s.length())
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int ways=solve1(s, idx+1, dp);
        if(idx+1<s.length() && Integer.parseInt(s.substring(idx, idx+2))<=26)
            ways+=solve1(s, idx+2, dp);
        return dp[idx]=ways;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays=new DecodeWays();
        String s="226";
        System.out.println(decodeWays.numDecodings(s));
    }
}
