package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/description/
public class PermutationSequence 
{
    public String getPermutation(int n, int k) {
        List<String>ans=new ArrayList<>();
        boolean check[]=new boolean[n+1];
        solve(n, k, new StringBuilder(), ans, check);
        System.out.println(ans);
        return ans.get(k-1);
    }

    void solve(int n, int k, StringBuilder str, List<String>ans, boolean check[])
    {
        if(str.length()==n)
        {
            ans.add(str.toString());
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if(!check[i])
            {
                str.append(i);
                check[i]=true;
                solve(n, k, str, ans, check);
                str.deleteCharAt(str.length()-1);
                check[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence=new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 3));
    }
}
