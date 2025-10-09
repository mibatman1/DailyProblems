package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.List;

public class SubSet 
{
    public List<List<Integer>> subsets(int[] nums) {
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
            ls.add(nums[i]);
            solve(ans, i+1, nums, ls);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        SubSet set=new SubSet();
        int arr[]={1,2,3};
        System.out.println(set.subsets(arr));
    }
}
