package dailyproblems.potd;

public class SpecialArray 
{
    public boolean isArraySpecial(int[] nums) 
    {
        if(nums.length==1)
            return true;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0 && nums[i+1]%2==0)
                return false;
        }
        return true;   
    }
}
