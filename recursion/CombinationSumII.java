package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII 
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, ans, 0, ls, 0);
        return ans;
    }

    void solve(int cand[], int target, List<List<Integer>>ans, int idx, List<Integer>ls, int sum)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(target<0)
            return;
        for(int i=idx;i<cand.length;i++)
        {
            if(i>idx && cand[i]==cand[i-1])
                continue;
            ls.add(cand[i]);
            solve(cand, target-cand[i], ans, i+1, ls, sum);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        int arr[]={10,1,2,7,6,1,5};
        int target=8;
        CombinationSumII combinationSumII=new CombinationSumII();
        System.out.println(combinationSumII.combinationSum2(arr, target));
    }
}
