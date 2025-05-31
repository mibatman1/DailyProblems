package dailyproblems.stringdp;

public class IsSubsequence 
{
    public boolean isSubsequence(String s, String t) {
        int i=0, j=0;
        while(i<t.length() && j<s.length())
        {
            if(t.charAt(i)==s.charAt(j))
            {
                j++;
            }
            i++;
        }
        return j==s.length();
    }

    public static void main(String[] args) 
    {
        IsSubsequence isSubsequence=new IsSubsequence();
        String s="abc";
        String s1="ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, s1));   
    }
}
