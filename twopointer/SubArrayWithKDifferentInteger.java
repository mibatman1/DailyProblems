package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDifferentInteger {

    public int subarraysWithKDistinct(int[] nums, int k) 
    {
        return solve(nums, k)-solve(nums, k-1);
    }

    private int solve(int nums[], int k)
    {
        int r=0, l=0, cnt=0;
        if(k<0)
            return 0;
        Map<Integer, Integer>mp=new HashMap<>();
        while(r<nums.length)
        {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0)+1);
            while(mp.size()>k)
            {
                mp.put(nums[l], mp.get(nums[l])-1);
                if(mp.get(nums[l])==0)
                {
                    mp.remove(nums[l]);
                }
                l++;
            }
            cnt=cnt+(r-l+1);
            r++;
        }
        return cnt;
    }
}
