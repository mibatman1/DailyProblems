package dailyproblems.updatedrecursion;

import java.util.List;

public class GenerateParenthesis 
{
    public List<String> generateParenthesis(int n) {

    }
    
    private void solve(List<String>ans, int n, int o, int c, String s)
    {
        if(o==n && c==n)
        {
            ans.add(s);
            return;
        }
        if(o<n)
        {
            solve(ans, n, o+1, c, s+"(");
        }
        if(c<o)
            solve(ans, n, o, c+1, s+")");
    }
}
