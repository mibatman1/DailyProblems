package dailyproblems.twopointerlatest;

// https://leetcode.com/problems/valid-palindrome-ii/description/
public class ValindPalindromeII 
{
    public boolean validPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
                return checkPalindome(s, l+1, r) || checkPalindome(s, l, r-1);
            l++;
            r--;
        }
        return true;
    }

    private boolean checkPalindome(String s, int i, int j)
    {
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }    
}
