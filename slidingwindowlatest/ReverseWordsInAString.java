package dailyproblems.slidingwindowlatest;

public class ReverseWordsInAString 
{
    public String reverseWords(String s) {
        String words[]=s.trim().split("\\s+");
        StringBuilder str=new StringBuilder();
        for(var i=words.length-1;i>0;i--)
            str.append(words[i]).append(" ");
        str.append(words[0]);
        return str.toString();
    }

    public static void main(String[] args) {
        
    }    
}
