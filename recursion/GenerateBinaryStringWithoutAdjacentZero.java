package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutAdjacentZero 
{
    public List<String> validStrings(int n) {
        List<String>ans=new ArrayList<>();
        solve2(ans, "", n);
        return ans;   
    }

    void solve2(List<String>ans, String str, int n)
    {
        if(str.length()==n)
        {
            ans.add(str.toString());
            return;
        }
        solve2(ans, str+"1", n);
        if(str.isEmpty() || str.charAt(str.length()-1)=='1')
        {
            solve2(ans, str+"0", n);
        }
    }

    void solve(List<String>ans, int i, StringBuilder str, boolean flag, int n)
    {
        if(i==n)
        {
            if(str.length()==n)
            {
                ans.add(str.toString());
                return;
            }
        }

        if(flag || i==0)
        {
            str.append("0");
            solve(ans, i+1, str, false, n);
            str.deleteCharAt(str.length()-1);
        }
        str.append("1");
        solve(ans, i+1, str, true, n);
        str.deleteCharAt(str.length()-1);
    }

    public static void main(String[] args) {
        GenerateBinaryStringWithoutAdjacentZero generateBinaryStringWithoutAdjacentZero=new GenerateBinaryStringWithoutAdjacentZero();
        System.out.println(generateBinaryStringWithoutAdjacentZero.validStrings(3));
    }
}
