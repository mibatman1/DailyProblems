package dailyproblems.twopointer;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar 
{
    public int lengthOfLongestSubstring(String s) {
        Set<Character>st=new HashSet<>();
        int l=0, r=0, len=0;
        while(r<s.length())
        {
            if(!st.contains(s.charAt(r)))
            {
                st.add(s.charAt(r));
                len=Math.max(len, r-l+1);
                r++;
            }
            else
            {
                st.remove(s.charAt(l));
                l++;
            }
        }
        return len;
    }
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar longestSubstringWithoutRepeatingChar=new LongestSubstringWithoutRepeatingChar();
        System.out.println(longestSubstringWithoutRepeatingChar.lengthOfLongestSubstring("pwwkew"));
    }
}
