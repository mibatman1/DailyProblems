package dailyproblems.twopointer;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        return solve(s).equals(solve(t));
    }

    private String solve(String s)
    {
        StringBuilder str=new StringBuilder();
        for(var ch:s.toCharArray())
        {
            if(ch!='#')
                str.append(ch);
            else if(str.length()!=0)
                str.deleteCharAt(str.length()-1);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare=new BackspaceStringCompare();
        String s="a#c";
        String t="b";
        System.out.println(backspaceStringCompare.backspaceCompare(s, t));
    }
}
