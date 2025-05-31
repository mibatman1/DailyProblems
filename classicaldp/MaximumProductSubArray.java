package dailyproblems.classicaldp;

// https://leetcode.com/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=m22s5qzg
// Imp
public class MaximumProductSubArray 
{
    public int maxProduct(int[] nums) 
    {
        int start=1, end=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(start==0)
                start=1;
            if(end==0)
                end=1;
            start*=nums[i];
            end*=nums[nums.length-i-1];
            max=Math.max(max, Math.max(start, end));
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumProductSubArray maximumProductSubArray=new MaximumProductSubArray();
        System.out.println(maximumProductSubArray.maxProduct(new int[]{1,2,3,-1,90}));
    }
}
