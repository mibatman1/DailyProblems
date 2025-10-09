package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionToKEqualSumSubset 
{
    public boolean canPartitionKSubsets(int[] nums, int k) {
        List<Integer>ans=new ArrayList<>();
        List<List<Integer>>ls=new ArrayList<>();
        Arrays.sort(nums);
        solve(ans, nums, k, 0, 0, ls);
        Map<Integer, Integer>mp=new HashMap<>();
        for(var i:ls)
        {
            int sum=0;
            for(var j:i)
            {
                sum+=j;
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        for(var i:mp.values())
        {
            if(i==k)
                return true;
        }
        return false;
    }
    
    private void solve(List<Integer>ans, int nums[], 
    int k, int count, int idx, List<List<Integer>>ls)
    {
        ls.add(new ArrayList<>(ans));
        for(var i=idx; i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1])
                continue;
            ans.add(nums[i]);
            solve(ans, nums, k, count, i+1, ls);
            ans.remove(ans.size()-1);
        }
    }
}
