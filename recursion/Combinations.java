package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations 
{
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ls=new ArrayList<>();
        solve(ans, ls, n, k, 1);
        return ans;
    }

    void solve(List<List<Integer>>ans, List<Integer>ls, int n, int k, int idx)
    {
        if(ls.size()==k)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<=n;i++)
        {
            ls.add(i);
            solve(ans, ls, n, k, i+1);
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations=new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
