package dailyproblems.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicate 
{
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer>mp=new HashMap<>();
        for(var it:nums)
        {
            mp.put(it, mp.getOrDefault(it,0)+1);
        }
        for(var it:mp.values())
        {
            if(it>=2)
                return false;
        }
        return true;
    }
    
}
