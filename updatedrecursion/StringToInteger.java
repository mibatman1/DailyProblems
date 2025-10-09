package dailyproblems.updatedrecursion;

public class StringToInteger 
{
    public int myAtoi(String s)
    {
        s=s.trim();
        int idx=0;
        int sign=0;
        if(s.length()==0)
            return 0;
        if(s.charAt(0)=='+')
        {
            idx++;
            sign=1;
        }
        else if(s.charAt(0)=='-')
        {
            idx++;
            sign=-1;
        }
        return (int)solve(sign, idx, s, 0);
    }
    
    private long solve(int sign, int idx, String s, long ans)
    {
        if(idx>=s.length() || !Character.isDigit(s.charAt(idx)-'0'))
            return ans*sign;
        ans=ans*10+(s.charAt(idx)-'0');
        if(ans>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if((ans*sign)<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return solve(sign, idx+1, s, ans);
    }
}
