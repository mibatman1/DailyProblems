package dailyproblems.recursion;

import java.util.List;

public class ExpressionAddOperator 
{
    public List<String> addOperators(String num, int target) {
        
    }

    private void solve(String num, int target, int idx, StringBuilder str, List<String>ls, int n)
    {
        if(idx==num.length()-1)
        {
            if(n==target)
            {
                ls.add(str.toString());
                return;
            }
        }
        n=num.charAt(idx)-'0';
        solve(num, n+num.charAt(idx)-target, idx+1, str.append(n).append('+'), ls, n);
        solve(num, n-num.charAt(idx)-target, idx+1, str.append(n).append('-'), ls, n);
        solve(num, n-num.charAt(idx)-target, idx+1, str.append(n).append('*'), ls, n);
    }    
}
