package dailyproblems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NextSpecialPalindromeNumber 
{
    private List<Integer>ls=new ArrayList<>();

    private void generate(int n)
    {
        
    }

    private long solve(int n)
    {
        int num=0;
        while(n>0)
        {
            num=(num*10)+(n%10);
            n/=10;
        }
        return num;
    }

    public static void main(String[] args) {
        //NextSpecialPalindromeNumber nextSpecialPalindromeNumber=new NextSpecialPalindromeNumber();
        System.out.println(1/2);    
    }    
}
