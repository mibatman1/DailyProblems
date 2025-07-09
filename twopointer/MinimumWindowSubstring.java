package dailyproblems.twopointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer>mp=new HashMap<>();
        int r=0, l=0,cut=0, minlen=Integer.MAX_VALUE, idx=-1;
        for(var a:t.toCharArray())
        {
            mp.put(a, mp.getOrDefault(a, 0)+1);
        }
        while(r<s.length())
        {
            if(mp.getOrDefault(s.charAt(r), 0)>0)
            {
                cut=cut+1;
                mp.put(s.charAt(r), mp.get(s.charAt(r))-1);
            }
            while(cut==t.length())
            {
                if(r-l+1<minlen)
                {
                    minlen=r-l+1;
                    idx=l;
                }
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                if(mp.get(s.charAt(l))>0)
                    cut=cut-1;
            }
            r++;
        }
        return idx==-1?"":s.substring(idx, minlen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring=new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
