package linerdp;

public class CountNumbersWithUniqueDigit 
{
    public int countNumbersWithUniqueDigits(int n) 
    {
        if(n==0)
            return 1;
        int start=9;
        int ans=10;
        int curr=9;
        while(n-->1 && start!=0)
        {
            curr*=start--;
            ans+=curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigit countNumbersWithUniqueDigit=new CountNumbersWithUniqueDigit();
        System.out.println(countNumbersWithUniqueDigit.countNumbersWithUniqueDigits(3));
    }
}
