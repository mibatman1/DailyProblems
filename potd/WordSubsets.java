package potd;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets 
{
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>ans=new ArrayList<>();
        int freq[]=new int[26];
        for(var it:words2)
        {
            int count[]=new int[26];
            for(var w:it.toCharArray())
            {
                count[w-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                freq[i]=Math.max(count[i], freq[i]);
            }
        }

        for(var it:words1)
        {
            int count[]=new int[26];
            for(var w:it.toCharArray())
            {
                count[w-'a']++;
            }
            int i=0;
            for(i=0;i<26;i++)
            {
                if(count[i]<freq[i])
                    break;
            }
            if(i==26)
                ans.add(it);
        }

        return ans;
    }

    public static void main(String[] args) {
        WordSubsets wordSubsets=new WordSubsets();
        String arr[]={"amazon","apple","facebook","google","leetcode"};
        String arr2[]={"l","e"};
        System.out.println(wordSubsets.wordSubsets(arr, arr2));
    }
}
