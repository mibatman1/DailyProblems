package recursion;

// https://leetcode.com/problems/count-good-numbers/description/?envType=problem-list-v2&envId=recursion
public class CountGoodNumber 
{
    public int countGoodNumbers(long n) 
    {
        int cnt=0;
        return solve(cnt, new StringBuilder(),n);     
    }

    int solve(int cnt, StringBuilder str, long n)
    {
        if(n==str.length())
            return 1;
    }
}
