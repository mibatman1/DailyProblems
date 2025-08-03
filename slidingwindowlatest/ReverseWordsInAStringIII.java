package dailyproblems.slidingwindowlatest;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        String words[]=s.split("\\s+");
        for(var i=0;i<words.length;i++)
        {
            str.append(reverse(words[i]));
            if(i<words.length-1)
                str.append(" ");
        }
        return str.toString();
    }

    private StringBuilder reverse(String s)
    {
        char ch[]=s.toCharArray();
        int l=0, r=ch.length-1;
        while(l<r)
        {
            char c=ch[l];
            ch[l]=ch[r];
            ch[r]=c;
            l++;
            r--;
        }
        return new StringBuilder().append(ch);
    }

    public static void main(String[] args) {
        
    }
}
