package dailyproblems.twopointer;

public class CountNumberOfNiceSubArray {

    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k)-solve(nums, k-1);
    }

    private int solve(int nums[], int k)
    {
        int l=0, r=0, cnt=0, sum=0;
        if(k<0)
            return 0;
        while(r<nums.length)
        {
            sum=sum+(nums[r]%2);
            while(sum>k)
            {
                sum=sum-(nums[l]%2);
                l--;
            }
            cnt=cnt+(r-l+1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        
    }
}
