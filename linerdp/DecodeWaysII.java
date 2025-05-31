package dailyproblems.linerdp;

public class DecodeWaysII 
{
    public int numDecodings(String s) {
        return solve(s, 0);
    }

    private int solve(String s, int idx)
    {
        if(idx==s.length())
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        int ways=solve(s, idx+1);
        if(idx+1<s.length() && Integer.parseInt(s.substring(idx, idx+2))<=26)
            ways+=solve(s, idx+2);
        return ways;
    }

    public static void main(String[] args) {
        DecodeWaysII decodeWaysII=new DecodeWaysII();
        String s="1234";
        System.out.println(decodeWaysII.numDecodings(s));
    }
}
