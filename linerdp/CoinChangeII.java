package linerdp;

public class CoinChangeII 
{
    public int change(int amount, int[] coins) 
    {
        return solve(amount, 0, coins);
    }

    int solve(int amount, int start, int coins[])
    {
        if(amount<0)
            return 0;
        if(amount==0)
            return 1;
        if(start==coins.length)
            return 0;
        int count=0;
        count+=solve(amount-coins[start], start, coins);
        count+=solve(amount, start+1, coins);
        return count;
    }

    public static void main(String[] args) {
        CoinChangeII coinChangeII=new CoinChangeII();
        int n=5;
        int arr[]={1,2,5};
        System.out.println(coinChangeII.change(n, arr));
    }
}
