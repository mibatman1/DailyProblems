package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharReplacement 
{
    public int characterReplacement(String s, int k) 
    {
        int l=0, r=0, len=0, maxfre=0;
        Map<Character, Integer>mp=new HashMap<>();
        while(r<s.length())
        {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0)+1);
            maxfre=Math.max(maxfre, mp.get(s.charAt(r)));
            if((r-l+1)-maxfre>k)
            {
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                maxfre=0;
                l++;
            }
            else if((r-l+1)-maxfre<=k)
            {
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        LongestRepeatingCharReplacement longestRepeatingCharReplacement=new LongestRepeatingCharReplacement();
        System.out.println(longestRepeatingCharReplacement.characterReplacement("ABAB",2));
    }
}
