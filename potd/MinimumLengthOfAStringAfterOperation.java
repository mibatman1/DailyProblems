package potd;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthOfAStringAfterOperation {

    public int minimumLength(String s) 
    {
        if(s.length()<3)
            return s.length();
        Map<Character, Integer>mp=new HashMap<>();
        int count=0;
        for(char ch:s.toCharArray())
        {
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        for(var fre:mp.values())
        {
            if(fre%2!=0)
                count+=1;
            else
                count+=2;
        }
        return count;    
    }
}
