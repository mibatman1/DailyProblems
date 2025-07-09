package dailyproblems.twopointer;

public class BinarySubArrayWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal)-solve(nums, goal-1);
    }

    private int solve(int nums[], int goal)
    {
        int r=0, l=0, cnt=0, sum=0;
        if(goal<0)
            return 0;
        while(r<nums.length)
        {
            sum+=nums[r];
            while(sum>goal)
            {
                sum=sum-nums[l];
                l++;
            }
            cnt=cnt+(r-l+1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        BinarySubArrayWithSum binarySubArrayWithSum=new BinarySubArrayWithSum();
        System.out.println(binarySubArrayWithSum.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
    
}
