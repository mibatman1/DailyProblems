package dailyproblems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int l=0, r=0, len=0, maxfreq=0;
        Map<Character, Integer>mp=new HashMap<>();
        while(r<s.length())
        {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0)+1);
            maxfreq=Math.max(maxfreq, s.charAt(r));
            if((r-l+1)-maxfreq>k)
            {
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                maxfreq=0;
                l++;
            }
            else if((r-l+1)-maxfreq<=k)
            {
                len=Math.max(len, r-l+1);
                r++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        
    }
}
