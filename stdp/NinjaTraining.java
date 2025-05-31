package dailyproblems.stdp;

import java.util.Arrays;

public class NinjaTraining 
{
    public int ninjaTraining(int n, int points[][]) {
        int dp[][]=new int[n+1][4];
        for(var it:dp)
            Arrays.fill(it, -1);
        //return solve(points, n-1, 3);
        //return solve1(points, n-1, 3, dp);
        //return solve2(points, dp, n);
        return solve3(points, n);
    }

    // Recursion
    private int solve(int points[][], int day, int last)
    {
        if(day==0)
        {
            int maxi=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                    maxi=Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<3;i++)
        {
            if(last!=i)
            {
                int point=points[day][i]+solve(points, day-1, i);
                maxi=Math.max(maxi, point);
            }
        }
        return maxi;
    }

    // Recursion + DP
    private int solve1(int points[][], int day, int last, int dp[][])
    {
        System.out.println("This is DP solution");
        if(day==0)
        {
            int max=0;
            for(int i=0;i<3;i++)
            {
                if(last!=i)
                {
                    max=Math.max(max, points[0][i]);
                }
            }
            return dp[day][last]=max;
        }
        if(dp[day][last]!=-1)
            return dp[day][last];
        int max=0;
        for(int i=0;i<3;i++)
        {
            if(last!=i)
            {
                int point=points[day][i]+solve1(points, day-1, i, dp);
                max=Math.max(max, point);
            }
        }
        return dp[day][last]=max;
    }

    // Tabulation(Bottom Up Approach)
    private int solve2(int nums[][], int dp[][], int n)
    {
        dp[0][0]=Math.max(nums[0][1], nums[0][2]);
        dp[0][1]=Math.max(nums[0][0], nums[0][2]);
        dp[0][2]=Math.max(nums[0][0], nums[0][1]);
        dp[0][3]=Math.max(nums[0][1],Math.max(nums[0][1], nums[0][2]));
        for(int day=1;day<n;day++)
        {
            for(int last=0;last<4;last++)
            {
                dp[day][last]=0;
                for(int task=0; task<3;task++)
                {
                    if(task!=last)
                    {
                        int point=nums[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    // Tabulation + Space Optimization
    private int solve3(int nums[][], int n)
    {
        int prev[]=new int[4];
        Arrays.fill(prev, 0);
        prev[0]=Math.max(nums[0][1], nums[0][2]);
        prev[1]=Math.max(nums[0][0], nums[0][2]);
        prev[2]=Math.max(nums[0][1], nums[0][0]);
        prev[3]=Math.max(nums[0][1],Math.max(nums[0][1], nums[0][2]));
        for(int day=1;day<n;day++)
        {
            int temp[]=new int[4];
            for(int last=0;last<4;last++)
            {
                for(int task=0;task<3;task++)
                {
                    if(last!=task)
                    {
                        temp[last]=Math.max(temp[last], nums[day][task]+prev[task]);
                    }
                }
            }
            prev=temp;
        }
        return prev[3];
    }

    public static void main(String[] args) {
        int arr[][]={{1,2,5},{3,1,1},{3,3,3}};
        NinjaTraining ninjaTraining=new NinjaTraining();
        System.out.println(ninjaTraining.ninjaTraining(3, arr));
    }
    
}
