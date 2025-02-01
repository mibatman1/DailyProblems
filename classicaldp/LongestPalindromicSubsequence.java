package classicaldp;

public class LongestPalindromicSubsequence 
{
    public int longestPalindromeSubseq(String s) 
    {
        StringBuilder str1=new StringBuilder(s);
        StringBuilder str2=new StringBuilder(str1.reverse());
        return solve(str1, str2, str1.length()-1, 0);
    }

    private int solve(StringBuilder str1, StringBuilder str2, int i, int j)
    {
        if(i<0 || j>=str2.length())
            return 0;
        if(str1.charAt(i)==str2.charAt(j))
            return 1+solve(str1, str2, i-1, j+1);
        return Math.max(solve(str1, str2, i-1, j), solve(str1, str2, i, j+1));
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence=new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubsequence.longestPalindromeSubseq("cbbd"));
    }
}
