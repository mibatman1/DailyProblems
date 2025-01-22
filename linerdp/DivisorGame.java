package linerdp;

// https://leetcode.com/problems/divisor-game/submissions/1517020493/?envType=problem-list-v2&envId=m221lq9s
public class DivisorGame 
{
    public boolean divisorGame(int n) {
        if(n<=1)
            return false;
        for(int i=1;i<n;i++)
        {
            if(n%i==0)
                return !divisorGame(n-i);
        }
        return false;   
    }

    // or Just do
    // return n%2==0
}
