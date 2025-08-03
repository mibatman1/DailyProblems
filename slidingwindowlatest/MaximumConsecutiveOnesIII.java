package dailyproblems.slidingwindowlatest;

public class MaximumConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k)
    {
        int l=0, zero=0, r=0, len=Integer.MIN_VALUE;
        while(r<nums.length)
        {
            if(nums[r]==0)
                zero++;
            if(zero>k)
            {
                if(nums[l]==0)
                    zero--;
                l++;
            }
            if(zero<=k)
            {
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        
    }
    
}
