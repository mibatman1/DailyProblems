package dailyproblems.potd;

public class ApplyOperationsToTheArray 
{
    public int[] applyOperations(int[] nums) 
    {
        int arr[]=new int[nums.length];
        int nonZero=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1] && nums[i]!=0)
            {
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        for(var num:nums)
        {
            if(num!=0)
                arr[nonZero++]=num;
        }
        while(nonZero<nums.length)
            arr[nonZero++]=0;
        return arr;   
    }

    public static void main(String[] args) {
        ApplyOperationsToTheArray applyOperationsToTheArray=new ApplyOperationsToTheArray();
        int arr[]={1,2,2,1,1,0};
        var a=applyOperationsToTheArray.applyOperations(arr);
        for(var it:a)
            System.out.print(it);
    }
}
