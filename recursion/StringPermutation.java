package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation 
{
    public ArrayList<String> findPermutation(String s) 
    {
        Set<String>st=new HashSet<>();
        boolean check[]=new boolean[s.length()];
        solve(0, s, new StringBuilder(), st, check);
        return new ArrayList<>(st); 
    }

    private void solve(int idx, String s, StringBuilder str, Set<String>st, boolean check[])
    {
        if(idx==s.length())
        {
            st.add(str.toString());
            return;
        }
        for(var i=0;i<s.length();i++)
        {
            if(!check[i])
            {
                check[i]=true;
                str.append(s.charAt(i));
                solve(idx+1, s, str, st, check);
                check[i]=false;
                str.deleteCharAt(str.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        StringPermutation stringPermutation=new StringPermutation();
        System.out.println(stringPermutation.findPermutation("ABSG"));
    }
}
