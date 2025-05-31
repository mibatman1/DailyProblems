package dailyproblems.potd;

public class MaximumAscendingSubarraySum 
{
    public int maxAscendingSum(int[] nums) {
        int max=Integer.MIN_VALUE, sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>=nums[i])
            {
                max=Math.max(max,sum);
                sum=0;
            }
            sum+=nums[i];
        }
        return Math.max(max, sum);   
    }

    public static void main(String[] args) {
        MaximumAscendingSubarraySum maximumAscendingSubarraySum=new MaximumAscendingSubarraySum();
        int arr[]={12,17,15,13,10,11,12};
        System.out.println(maximumAscendingSubarraySum.maxAscendingSum(arr));
    }
}
