package dailyproblems.slidingwindow;

public class ShortestSubArrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        int r=0, l=0, len=Integer.MAX_VALUE, sum=0;
        while(r<nums.length)
        {
            if(sum>k)
            {
                sum-=nums[l];
                l++;
            }
            if(sum<k)
            {
                sum+=nums[r];
            }
            if(sum>=k)
            {
                len=Math.min(len, r-l+1);
            }
            r++;
        }
        return len==Integer.MAX_VALUE?-1:len;
    }

    public static void main(String[] args) {
        
    }
}
