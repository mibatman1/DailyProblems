package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {

    }
    
    private void solve(List<List<Integer>>ans, List<Integer>ls, int nums[], int target, int idx)
    {
        if(idx==nums.length && target==0)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(nums[idx]<=target)
        {
            ls.add(nums[idx]);
            solve(ans, ls, nums, target-nums[idx], idx);
            ls.remove(ls.size()-1);
        }
        solve(ans, ls, nums, target, idx+1);
    }
}
