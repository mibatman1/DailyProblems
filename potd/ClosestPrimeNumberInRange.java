package dailyproblems.potd;

import java.util.ArrayList;
import java.util.List;

public class ClosestPrimeNumberInRange 
{
    public int[] closestPrimes(int left, int right) {
        solve(left, right);
        return new int[]{0,1};
    }

    private List<Integer> solve(int start, int end)
    {
        List<Integer>ls=new ArrayList<>();
        for(int i=start;i<=end;i++)
        {
            if(isPrime(i))
                ls.add(i);
        }
        System.out.println(ls);
        return ls;
    }

    private boolean isPrime(int n)
    {
        if(n<2)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ClosestPrimeNumberInRange closestPrimeNumberInRange=new ClosestPrimeNumberInRange();
        closestPrimeNumberInRange.closestPrimes(10, 19);
    }
}
