package dailyproblems.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        String str = null;
        List<Integer>res=new ArrayList<>();
        for(var a:words)
            str+=a;
        str=sort(str);
        for(var i=0;i<=s.length()-str.length();i++)
        {
            if(str.equals(sort(s.substring(i, i+str.length()))))
                res.add(i);
        }
        return res;
    }

    private String sort(String s)
    {
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return ch.toString();
    }

    public static void main(String[] args) {
        
    }
}
