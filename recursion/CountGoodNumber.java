package recursion;

// https://leetcode.com/problems/count-good-numbers/description/?envType=problem-list-v2&envId=recursion
public class CountGoodNumber 
{
    public int countGoodNumbers(long n) 
    {
        return solve(n);     
    }

    int solve(long n)
    {
        if(n==0)
            return 1;
    }
}
