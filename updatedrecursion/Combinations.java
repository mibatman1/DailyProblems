package dailyproblems.updatedrecursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations 
{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(n,k, ans, ls, 1);
        return ans;
    }
    
    private void solve(int n, int k, List<List<Integer>>ans, List<Integer>ls, int idx)
    {
        if(ls.size()==k)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<=n;i++)
        {
            ls.add(i);
            solve(n, k, ans, ls, i+1);
            ls.remove(ls.size()-1);
        }
    }
}
