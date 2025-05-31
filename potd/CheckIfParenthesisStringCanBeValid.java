package dailyproblems.potd;

public class CheckIfParenthesisStringCanBeValid 
{
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2!=0)
            return false;
        int n=s.length();
        int unlocked=0;
        int openBracket=0;
        int balance=0;
        for(int i=0;i<n;i++)
        {
            if(locked.charAt(i)=='0')
            {
                unlocked++;
            }
            if(s.charAt(i)=='(')
            {
                openBracket++;
            }
            else if(s.charAt(i)==')')
            {
                if(openBracket>0)
                {
                    openBracket--;
                }
                else if(unlocked>0)
                {
                    unlocked--;
                }
                else 
                {
                    return false;
                }
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            if(locked.charAt(i)=='0')
            {
                balance--;
                unlocked--;
            }
            if(s.charAt(i)=='(')
            {
                balance++;
                unlocked++;
            }
            else if(s.charAt(i)==')')
            {
                balance--;
            }
            if(balance>0)
                return false;
            if(unlocked==0 && openBracket==0)
            {
                break;
            }
        }
        if(openBracket>0)
            return false;
        return true;
    }
}
