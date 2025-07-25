package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome 
{
    public boolean isPalindrome(String s) {
        StringBuilder str=new StringBuilder();
        for(var ch:s.toCharArray())
        {
            if(Character.isDigit(ch) || Character.isAlphabetic(ch))
                str.append(Character.toLowerCase(ch));
        }
        int l=0, r=str.length()-1;
        if(str.length()==0)
            return true;
        while(l<r)
        {
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        ValidPalindrome validPalindrome=new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("0P"));    
    }    
}
