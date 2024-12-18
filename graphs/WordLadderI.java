package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://www.geeksforgeeks.org/problems/word-ladder/1


public class WordLadderI 
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair>q=new LinkedList<>();
        Set<String>st=new HashSet<String>();
        for(var str:wordList)
        {
            st.add(str);
        }
        q.add(new Pair(startWord, 1));
        st.remove(startWord);
        while(!q.isEmpty())
        {
            var node=q.poll();
            var words=node.word;
            var steps=node.steps;
            if(words.equals(targetWord))
                return steps;
            for(int i=0;i<words.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char arr[]=words.toCharArray();
                    arr[i]=ch;
                    String replacedWord=new String(arr);
                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        WordLadderI wordLadderI=new WordLadderI();
        String str[]={"des","der","dfr","dgt","dfs"};
        String targetWord="dfs"; String startWord="der";
        System.out.println(wordLadderI.wordLadderLength(startWord, targetWord, str));
    }

    class Pair
    {
        int steps;
        String word;
        public Pair(String word, int steps)
        {
            this.steps=steps;
            this.word=word;
        }
    }
}

