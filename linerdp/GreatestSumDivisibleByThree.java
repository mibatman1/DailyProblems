package dailyproblems.linerdp;

public class GreatestSumDivisibleByThree 
{
    private int ans=0;
    public int maxSumDivThree(int[] nums) 
    {
        solve(nums, 0, 0);
        return ans;
    }

    void solve(int nums[], int idx, int sum)
    {
        if(idx==nums.length)
        {
            if(sum%3==0)
            {
                ans=Math.max(sum, ans);
                return;
            }
        }
        if(idx>=nums.length)
            return;
        solve(nums, idx+1, sum+nums[idx]);
        solve(nums, idx+1, sum);
    }

    public static void main(String[] args) {
        int arr[]={3,6,5,1,8};
        GreatestSumDivisibleByThree greatestSumDivisibleByThree=new GreatestSumDivisibleByThree();
        System.out.println(greatestSumDivisibleByThree.maxSumDivThree(arr));
    }
}
