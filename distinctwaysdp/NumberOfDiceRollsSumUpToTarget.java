package dailyproblems.distinctwaysdp;

import java.util.Arrays;

public class NumberOfDiceRollsSumUpToTarget 
{
    private int mod=(int)Math.pow(10, 9)+7;
    public int numRollsToTarget(int n, int k, int target) {
        int memo[][]=new int[n+1][target+1];
        for(var a:memo)
            Arrays.fill(a,-1);
        return solve1(n, k, target, memo);
        // /return solve(n, k, target);
    }

    private int solve(int n, int k, int target)
    {
        if(target==0 && n==0)
            return 1;
        if(n==0 || target<0)
            return 0;
        int count=0;
        for(int i=1;i<=k;i++)
        {
            count=(count+solve(n-i, k, target-i)%mod)%mod;
        }
        return count;
    }

    private int solve1(int n, int k, int target, int memo[][])
    {
        if(target==0 && n==0)
            return 1;
        if(n==0 || target<0)
            return 0;
        if(memo[n][target]!=-1)
            return memo[n][target];
        int count=0;
        for(int i=1;i<=k;i++)
        {
            count=(count+solve1(n-1, k, target-i, memo)%mod)%mod;
        }
        return memo[n][target]=count;
    }

    public static void main(String[] args) {
        NumberOfDiceRollsSumUpToTarget numberOfDiceRollsSumUpToTarget=new NumberOfDiceRollsSumUpToTarget();
        System.out.println(numberOfDiceRollsSumUpToTarget.numRollsToTarget(30, 30, 500));
    }
    
}
