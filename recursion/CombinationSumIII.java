package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII 
{
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(ans, ls, k, n, 1);
        return ans;
    }

    void solve(List<List<Integer>>ans, List<Integer>ls, int k, int n, int idx)
    {
        if(n==0)
        {
            if(ls.size()==k)
            {
                ans.add(new ArrayList<>(ls));
                return;
            }
        }
        if(n<0)
        {
            return;
        }
        for(int i=idx;i<10;i++)
        {
            ls.add(i);
            solve(ans, ls, k, Math.abs(n-i), i+1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII=new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3, 9));
    }
}
