package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings 
{
    public boolean isIsomorphic(String s, String t) 
    {
        Map<Character, Character>mp=new HashMap<>();
        if(s.length()!=t.length())
            return false;
        if(s.length()==1 && t.length()==1)
            return true;
        for(int i=0;i<s.length();i++)
        {
            if(!mp.containsKey(s.charAt(i)))
            {
                if(mp.containsValue(t.charAt(i)))
					return false;
                mp.put(s.charAt(i),t.charAt(i));
            }
            else
            {
                if(!mp.get(s.charAt(i)).equals(t.charAt(i)))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicString=new IsomorphicStrings();
        System.out.println(isomorphicString.isIsomorphic("ab", "ab"));
    }
}
