package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation 
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(ans, ls, nums, 0);
        return ans;
    }
    
    private void solve(List<List<Integer>>ans, List<Integer>ls, int nums[], int idx)
    {
        if(ls.size()==nums.length)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(var i=idx;i<nums.length;i++)
        {
            if(ls.contains(nums[i]))
                continue;
            ls.add(nums[i]);
            solve(ans, ls, nums, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
