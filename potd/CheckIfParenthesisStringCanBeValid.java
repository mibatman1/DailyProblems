package potd;

public class CheckIfParenthesisStringCanBeValid 
{
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0)
            return false;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)==')' && s.charAt(i)==')' || s.charAt(i)=='')

        }   
    }
}
