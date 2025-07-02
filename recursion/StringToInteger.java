package dailyproblems.recursion;

public class StringToInteger 
{
    public int myAtoi(String s) 
    {
        s=s.trim();
        int sign=1;
        int idx=0;
        if(s.length()==0)
            return 0;
        if(s.charAt(0)=='+')
        {
            idx++;
        }
        else if(s.charAt(0)=='-')
        {
            sign=-1;
            idx++;
        }
        return (int)solve(idx, s, sign, 0);
    }

    private long solve(int idx, String s, int sign, long ans)
    {
        if(idx>=s.length() || !Character.isDigit(s.charAt(idx)))
        {
            return ans*sign;
        }
        ans=ans*10+(s.charAt(idx)-'0');
        if(sign==1 && ans>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(sign==-1 && ans*sign<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return solve(idx+1, s, sign, ans);
    }

    public static void main(String[] args) 
    {
        StringToInteger stringToInteger=new StringToInteger();
        System.out.println(stringToInteger.myAtoi("0123"));   
    }
}
