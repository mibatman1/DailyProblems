package dailyproblems.potd;

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualParts 
{
    private Map<Integer, Integer>mp=new HashMap<>();

    public boolean divideArray(int[] nums) {
        return solve(nums);
    }

    private boolean solve(int nums[])
    {
        if(nums.length%2!=0)
            return false;
        for(var a:nums)
        {
            mp.put(a, mp.getOrDefault(a, 0)+1);
        }
        for(var a:mp.values())
        {
            if(a%2!=0)
                return false;
        }
        return true;
    }
    
}
