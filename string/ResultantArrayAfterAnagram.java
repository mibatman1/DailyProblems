package dailyproblems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultantArrayAfterAnagram 
{
    public boolean anagrams(String s1, String s2)
    {
        char ch[]=s1.toCharArray();
        char ck[]=s2.toCharArray();
        Arrays.sort(ch);
        Arrays.sort(ck);
        return Arrays.equals(ch, ck);
    }

    public List<String> removeAnagrams(String[] words) 
    {
        List<String>ans=new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++)
        {
            if(!anagrams(words[i], words[i-1]))
            {
                ans.add(words[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        String ar[]={"a","b","a"};
        ResultantArrayAfterAnagram resultantArrayAfterAnagram=new ResultantArrayAfterAnagram();
        System.out.println(resultantArrayAfterAnagram.removeAnagrams(ar));
        
    }
}
