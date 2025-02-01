package classicaldp;

// https://leetcode.com/problems/maximum-subarray/description/?envType=problem-list-v2&envId=m22s5qzg
// Important
public class MaximumSumSubArray 
{
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int start=0;
        for(int i=0;i<nums.length;i++)
        {
            start+=nums[i];
            if(start<0)
                start=0;
            max=Math.max(start, max);
        }
        return max;   
    }

    public static void main(String[] args) {
        MaximumSumSubArray maximumSumSubArray=new MaximumSumSubArray();
        System.out.println(maximumSumSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
