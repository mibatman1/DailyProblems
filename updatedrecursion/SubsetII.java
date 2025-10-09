package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII 
{
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(ans, 0, nums, ls);
        return ans;
    }
    
    private void solve(List<List<Integer>>ans, int idx, int nums[], List<Integer>ls)
    {
        ans.add(new ArrayList<>(ls));
        for(var i=idx;i<nums.length;i++)
        {
            if(i>idx && nums[i]==nums[i-1])
                continue;
            ls.add(nums[i]);
            solve(ans, i+1, nums, ls);
            ls.remove(ls.size()-1);
        }
    }
}
