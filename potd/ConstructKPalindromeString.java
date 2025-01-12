package potd;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeString 
{
    // public boolean canConstruct(String s, int k) {
    //     Map<Character, Integer>mp=new HashMap<>();
    //     int oddCount=0;
    //     if(s.length()<k)
    //         return false;
    //     for(var ch:s.toCharArray())
    //     {
    //         mp.put(ch, mp.getOrDefault(ch, 0)+1);
    //     }
    //     for(var cnt:mp.values())
    //     {
    //         if(cnt%2!=0)
    //             oddCount++;
    //     }
    //     return oddCount<=k;
    // }

    public boolean canConstruct(String s, int k) {
        if(s.length()<k)
            return false;
        if(s.length()==k)
            return true;
        int freq[]=new int[26];
        int cnt=0;
        for(var ch:s.toCharArray())
            freq[ch-'a']++;
        for(var fr:freq)
        {
            if(fr%2!=0)
                cnt++;
        }
        return cnt<=k;
    }
}
