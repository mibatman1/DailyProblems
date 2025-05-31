package dailyproblems.string;

public class ReverseWordsInString 
{
    //The sky is blue
    //blue is sky the
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        StringBuilder res=new StringBuilder();
        s=s.trim();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ')
            {
                str.append(s.charAt(i));
            }
            else if(s.charAt(i+1)!=' ')
            {
                res.insert(0, str);
                str.setLength(0);
                res.insert(0, " ");
            }
            if(i==s.length()-1)
            {
                res.insert(0, str);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) 
    {
        ReverseWordsInString reverseWordsInString=new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("  My name is khan  "));
    }
}
