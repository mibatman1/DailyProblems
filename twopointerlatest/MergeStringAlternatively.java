package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/merge-strings-alternately/description/
public class MergeStringAlternatively 
{
    public String mergeAlternately(String word1, String word2) 
    {
        StringBuilder str=new StringBuilder();
        int maxLen=Math.max(word1.length(), word2.length());
        for(var i=0;i<maxLen;i++)
        {
            if(i<word1.length())
                str.append(word1.charAt(i));
            if(i<word2.length())
                str.append(word2.charAt(i));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        
    }    
}
