package dailyproblems.recursion;

// https://leetcode.com/problems/count-good-numbers/description/?envType=problem-list-v2&envId=recursion
public class CountGoodNumber 
{
    public int countGoodNumbers(long n) 
    {
        long even=(n+1)/2;
        long odd=n/2;
        double e=Math.pow(5, even);
        double o=Math.pow(4, odd);
        return (int) (e*o); 
    }

    public static void main(String[] args) 
    {
        CountGoodNumber countGoodNumber=new CountGoodNumber();
        System.out.println(countGoodNumber.countGoodNumbers(4));
    }
}
