package recursion;

// https://leetcode.com/problems/climbing-stairs/?envType=problem-list-v2&envId=mk7l73rc
public class ClimbingStairs 
{
    public int climbStairs(int n) 
    {
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs=new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(10));
    }
}
