package dailyproblems.stringdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain 
{
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    public int longestStrChain(String[] words) {
        List<String>ls=new ArrayList<>();
        for(var a:words)
            ls.add(a);
        ls.sort(comp);
        int dp[]=new int[words.length+1];
        Arrays.fill(dp, 1);
        
        int max=1;
        // System.out.println(ls);
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[i]<dp[j]+1 && compare(ls.get(i), ls.get(j)))
                {
                    dp[i]=dp[j]+1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }    
        return max;
    }

    private boolean compare(String s1, String s2)
    {
        if(s1.length()!=s2.length()+1)
            return false;
        int p1=0, p2=0;
        while(p1<s1.length())
        {
            if(p2<s2.length() && s1.charAt(p1)==s2.charAt(p2))
            {
                p2++;
                p1++;
            }
            else
            {
                p1++;
            }
        }
        return p1==s1.length() && p2==s2.length();
    }

    public static void main(String[] args) {
        LongestStringChain longestStringChain=new LongestStringChain();
        String arr[]={"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(longestStringChain.longestStrChain(arr));
    }
}
