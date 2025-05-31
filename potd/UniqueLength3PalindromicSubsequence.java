package dailyproblems.potd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueLength3PalindromicSubsequence 
{
    public int countPalindromicSubsequence(String s) 
    {
        List<String>ans=new ArrayList<>();
        Set<String>st=new HashSet<>();
        StringBuilder str=new StringBuilder();
        solve(s, 0, str, st);
        System.out.println(st);
        return ans.size();
    }

    void solve(String s, int idx, StringBuilder str, Set<String>st)
    {
        if(str.length()==3 && isPalindrome(str.toString()))
        {
            st.add(str.toString());
            return;
        }
        if(idx>=s.length())
            return;
        str.append(s.charAt(idx));
        solve(s, idx+1, str, st);
        str.deleteCharAt(str.length()-1);
        solve(s, idx+1, str, st);
    }

    boolean isPalindrome(String str)
    {
        int s=0;
        int e=str.length()-1;
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
        UniqueLength3PalindromicSubsequence uniqueLength3PalindromicSubsequence=new UniqueLength3PalindromicSubsequence();
        System.out.println(uniqueLength3PalindromicSubsequence.countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
    }
}
