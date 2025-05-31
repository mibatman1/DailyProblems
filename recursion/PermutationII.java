package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII 
{
    public List<List<Integer>> permuteUnique(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        boolean check[]=new boolean[nums.length];
        solve(ans, ls, 0, nums, check);
        return ans;
    }

    void solve(List<List<Integer>>ans, List<Integer>ls, int idx, int nums[], boolean check[])
    {
        if(ls.size()==nums.length)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!check[i])
            {
                if(i>0 && nums[i]==nums[i-1] && !check[i-1])
                {
                    continue;
                }
                ls.add(nums[i]);
                check[i]=true;
                solve(ans, ls, i+1, nums, check);
                ls.remove(ls.size()-1);
                check[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        PermutationII permutationII=new PermutationII();
        System.out.println(permutationII.permuteUnique(arr));
    }
}
