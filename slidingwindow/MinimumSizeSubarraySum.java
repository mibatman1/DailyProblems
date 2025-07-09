package dailyproblems.slidingwindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {

        int r=0, l=0, len=Integer.MAX_VALUE, sum=0;

        while(r<nums.length)
        {
            sum+=nums[r];
            if(sum>=target)
            {
                len=Math.min(len, r-l+1);
                sum-=nums[l];
                l++;
            }
            r++;
        }

        return len==Integer.MAX_VALUE?0:len;
    }

    public static void main(String[] args) {
        
    }
    
}
