package dailyproblems.slidingwindowlatest;

import java.util.Arrays;

public class PermutationInAString 
{
    public boolean checkInclusion(String s1, String s2) {
        char ch[]=new char[26];
        char ch2[]=new char[26];
        int r=0, l=0;
        for(var a:s1.toCharArray())
        {
            ch[a-'a']++;
        }
        while(r<s2.length())
        {
            ch2[s2.charAt(r)-'a']++;
            if((r-l+1)>s1.length())
            {
                ch2[s2.charAt(l)-'a']--;
                l++;
            }
            if(Arrays.equals(ch, ch2))
                return true;
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
    
}
