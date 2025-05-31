package dailyproblems.potd;

public class RemoveAllOccuranceOfAString 
{
    public String removeOccurrences(String s, String part)
    {
        int n=part.length();
        StringBuilder str=new StringBuilder(s);
        while(str.indexOf(part)!=-1)
        {
            int idx=str.indexOf(part);
            str.delete(idx, idx+n);
        }
        return str.toString();
    } 

    public static void main(String[] args) {
        String s="abcbbbaabc";
        String part="abc";
        RemoveAllOccuranceOfAString removeAllOccuranceOfAString=new RemoveAllOccuranceOfAString();
        System.out.println(removeAllOccuranceOfAString.removeOccurrences(s, part));
    }
}
