package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfNumber 
{
    private static Map<Character, String>mp=new HashMap<>();
    static
    {
        mp.put('2', "abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) 
    {   
        List<String>ans=new ArrayList<>();
        if(digits.length()==0 || digits==null)
            return ans;
        solve(ans, digits, new StringBuilder(), 0);
        return ans;
    }

    void solve(List<String>ans, String digits, StringBuilder str, int index)
    {
        if(digits.contains("1"))
        {
            ans.add(new String());
            return;
        }
        if(digits.length()==index)
        {
            ans.add(str.toString());
            return;
        }
        var ch=digits.charAt(index);
        String key=mp.get(ch);
        for(var c:key.toCharArray())
        {
            str.append(c);
            solve(ans, digits, str, index+1);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfNumber letterCombinationOfNumber=new LetterCombinationOfNumber();
        System.out.println(letterCombinationOfNumber.letterCombinations("12"));
    }
}
