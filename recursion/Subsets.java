package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(ans, ls, nums, 0);
        return ans;
    }

    void solve(List<List<Integer>>ans, List<Integer>ls, int nums[], int idx)
    {
        ans.add(new ArrayList<>(ls));
        for(int i=idx;i<nums.length;i++)
        {
            ls.add(nums[i]);
            solve(ans, ls, nums, i+1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,2};
        Subsets subsets=new Subsets();
        System.out.println(subsets.subsets(arr));
    }
}
