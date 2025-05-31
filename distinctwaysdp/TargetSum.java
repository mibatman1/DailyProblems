package dailyproblems.distinctwaysdp;

public class TargetSum 
{
    private int totalWays=0;

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private int solve(int nums[], int target, int idx, int currSum)
    {
        if(idx==nums.length)
        {
            if(target==currSum)
            {
                return totalWays++;
            }
        }
        else
        {
            solve(nums, target, idx+1, currSum+nums[idx]);
            solve(nums, target, idx+1, currSum-nums[idx]);
        }
        return totalWays;
    }

    // Recursion + DP
    private int solve1()
    {

    }

    public static void main(String[] args) {
        TargetSum targetSum=new TargetSum();
        int arr[]={1,1,1,1,1};
        int target=3;
        System.out.println(targetSum.findTargetSumWays(arr, target));
    }
    
}
