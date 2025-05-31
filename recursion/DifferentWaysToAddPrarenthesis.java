package dailyproblems.recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=problem-list-v2&envId=mk7l73rc
public class DifferentWaysToAddPrarenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<expression.length();i++)
        {
            char ch=expression.charAt(i);
            if(ch=='+'|| ch=='-'|| ch=='*')
            {
                List<Integer>left=diffWaysToCompute(expression.substring(0,i));
                List<Integer>right=diffWaysToCompute(expression.substring(i+1));
                for(var l:left)
                {
                    for(var r:right)
                    {
                        if(ch=='+')
                            ans.add(l+r);
                        else if(ch=='-')
                            ans.add(l-r);
                        else if(ch=='*')
                            ans.add(l*r);
                    }
                }
            }
        }
        if(ans.isEmpty())
            ans.add(Integer.parseInt(expression));
        return ans;
    }

    public static void main(String[] args) {
        DifferentWaysToAddPrarenthesis differentWaysToAddPrarenthesis=new DifferentWaysToAddPrarenthesis();
        System.out.println(differentWaysToAddPrarenthesis.diffWaysToCompute("2+3*3"));
    }
}
