package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning 
{
    public List<List<String>> partition(String s) 
    {
        List<List<String>>ans=new ArrayList<>();
        List<String>an=new ArrayList<>();
        solve(ans, 0, an, s);
        return ans;
    }

    void solve(List<List<String>>ans, int idx, List<String>st, String s)
    {
        if(s.length()==idx)
        {
            ans.add(new ArrayList<>(st));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(isPalindrome(s, idx, i))
            {
                System.out.println(s.substring(idx, i+1));
                st.add(s.substring(idx, i+1));
                solve(ans, i+1, st, s);
                st.remove(st.size()-1);
            }
        }
    }

    boolean isPalindrome(String str, int s, int e)
    {
        if(str.length()==1)
            return true;
        while(s<=e)
        {
            if(str.charAt(s++)!=str.charAt(e--))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning=new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
    }
}
