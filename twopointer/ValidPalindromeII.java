package dailyproblems.twopointer;

// https://leetcode.com/problems/valid-palindrome-ii/description/?envType=problem-list-v2&envId=m2762w11
public class ValidPalindromeII 
{
    public boolean validPalindrome(String s) 
    {
        int i=0, j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return solve(s, i, j-1) || solve(s, i+1, j);
            }
            i++;
            j--;
        }
        return true;    
    }
    
    private boolean solve(String s, int i, int j)
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
        ValidPalindromeII validPalindromeII=new ValidPalindromeII();
        String s="abc";
        System.out.println(validPalindromeII.validPalindrome(s));
    }
}
