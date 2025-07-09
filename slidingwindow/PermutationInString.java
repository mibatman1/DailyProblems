package dailyproblems.slidingwindow;

import java.util.Arrays;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int ch[]=new int[26];
        int ch1[]=new int[26];
        Arrays.fill(ch, 0);
        Arrays.fill(ch1, 0);
        for(var a:s1.toCharArray())
        {
            ch[a-'a']++;
        }
        int l=0, r=0;
        while(r<s2.length())
        {
            ch1[s2.charAt(r)-'a']++;
            if((r-l+1)>s1.length())
            {
                ch1[s2.charAt(l)-'a']--;
                l++;
            }
            if(Arrays.equals(ch, ch1))
                return true;
            r++;
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
        var str=getString(s1);
        for(var i=0;i<=s2.length()-s1.length();i++)
        {
            if(str.equals(getString(s2.substring(i, i+s1.length()))))
                return true;
        }
        return false;
    }

    private String getString(String s)
    {
        char ch[]=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public static void main(String[] args) {
        
    }
}
