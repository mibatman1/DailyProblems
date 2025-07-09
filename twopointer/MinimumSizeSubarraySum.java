package dailyproblems.twopointer;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int l=0, r=0, len=Integer.MAX_VALUE, sum=0;
        while(r<nums.length)
        {
            sum=sum+nums[r];
            while(sum>=target)
            {
                len=Math.min(len, r-l+1);
                sum-=nums[l++];
            }
            r++;
        }
        return len==Integer.MAX_VALUE?0:len;    
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,2,4,3};
        MinimumSizeSubarraySum minimumSizeSubarraySum=new MinimumSizeSubarraySum();
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(7, arr));
    }
}
