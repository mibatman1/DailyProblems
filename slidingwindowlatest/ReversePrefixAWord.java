package dailyproblems.slidingwindowlatest;

public class ReversePrefixAWord {

    public String reversePrefix(String word, char ch) {
        StringBuilder str=new StringBuilder();
        int till=0;
        for(var i=0;i<word.length();i++)
        {
            if(word.charAt(i)==ch)
            {
                till=i;
                break;
            }
        }
        int l=0;
        char s[]=word.substring(0, till+1).toCharArray();
        while(l<till)
        {
            char c=s[l];
            s[l]=s[till];
            s[till]=c;
            l++;
            till--;
        }
        str.append(s);
        str.append(word.substring(till));
        return str.toString();    
    }

    public static void main(String[] args) {
        
    }    
}
