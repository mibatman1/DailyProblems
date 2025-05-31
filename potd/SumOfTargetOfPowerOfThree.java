package dailyproblems.potd;

public class SumOfTargetOfPowerOfThree 
{
    public boolean checkPowersOfThree(int n) {
        return solve(0, n);
    }

    private boolean solve(int pow, int n)
    {
        if(n==0)
            return true;
        if(Math.pow(3, pow)>n)
            return false;
        boolean take=solve(pow+1, n-(int)Math.pow(3, pow));
        boolean notTake=solve(pow+1, n);
        return take || notTake;
    }

    public static void main(String[] args) {
        SumOfTargetOfPowerOfThree sumOfTargetOfPowerOfThree=new SumOfTargetOfPowerOfThree();
        System.out.println(sumOfTargetOfPowerOfThree.checkPowersOfThree(91));
    }
}

// Kanpsack, Multi, Grid, Distinct ways DP.
// 
