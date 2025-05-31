package dailyproblems.potd;

// https://leetcode.com/problems/counting-words-with-a-given-prefix/?envType=daily-question&envId=2025-01-09
public class CountingWordsWithGivenPrefix 
{
    public int prefixCount(String[] words, String pref) {
        int cnt=0;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].startsWith(pref))
            {
                cnt++;
            }
        }
        return cnt;
    }
}
