package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctChars {

    public int longestSubstringWithAtMostDistinctChar(String s, int k){
        Map<Character, Integer>mp=new HashMap<>();
        int r=0, l=0, len=0;
        while(r<s.length()){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0)+1);
            if(mp.size()>k){
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                if(mp.get(s.charAt(l))==0)
                    mp.remove(s.charAt(l));
                l++;
            }
            else if(mp.size()<=k){
                len=Math.max(len, r-l+1);
            }
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtmostKDistinctChars longestSubstringWithAtmostKDistinctChars=new LongestSubstringWithAtmostKDistinctChars();
        System.out.println(longestSubstringWithAtmostKDistinctChars.longestSubstringWithAtMostDistinctChar("aaabbccd",2));
    }
    
}
