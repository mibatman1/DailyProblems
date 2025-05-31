package dailyproblems.potd;

//https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05
public class OneSwapCanMakeStringEqual 
{
    public boolean areAlmostEqual(String s1, String s2) 
    {
        int cnt=0;
        if(s1.equals(s2))
            return true;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                if(cnt>=2)
                    return false;
                cnt++;
            }
        }
        return true;   
    }
    
    public static void main(String[] args) {
        OneSwapCanMakeStringEqual oneSwapCanMakeStringEqual=new OneSwapCanMakeStringEqual();
        System.out.println(oneSwapCanMakeStringEqual.areAlmostEqual("attack", "defend"));
    }
}
