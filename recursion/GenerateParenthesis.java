package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis 
{
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        if(n==1)
        {
            ans.add("()");
            return ans;
        }
        solve(ans, n,"", 0, 0);
        return ans;
    }

    void solve(List<String>ans, int n, String str, int o, int c)
    {
        if(o==n && c==n)
        {
            ans.add(str);
            return;
        }
        if(o<n)
        {
            solve(ans, n, str+"(", o+1, c);
        }
        if(c<o)
        {
            solve(ans, n, str+")", o, c+1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis=new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
