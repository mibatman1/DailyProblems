package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation 
{
    public List<String> letterCasePermutation(String s) {
        List<String>ans=new ArrayList<>();
        solve(ans, 0, s.toCharArray());
        return ans;
    }

    void solve(List<String>ans, int i, char ch[])
    {
        if(i==ch.length)
        {
            ans.add(new String(ch));
            return;
        }
        if(Character.isLetter(ch[i]))
        {
            ch[i]=Character.toUpperCase(ch[i]);
            solve(ans, i+1, ch);
            ch[i]=Character.toLowerCase(ch[i]);
            solve(ans, i+1, ch);
        }
        else
        {
            solve(ans, i+1, ch);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation=new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation("a1b2"));
    }
}
