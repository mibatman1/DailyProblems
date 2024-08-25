package stacksqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveParen 
{
    public String removeOuterParentheses(String s) 
    {
        StringBuilder str=new StringBuilder();
        Deque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(st.size()>0)
                {
                    str.append(s.charAt(i));
                }
                st.push(s.charAt(i));
            }
            else
            {
                st.pop();
                if(st.size()>0)
                {
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }
    
    public static void main(String[] args) {
        RemoveParen removeParen=new RemoveParen();
        System.out.println(removeParen.removeOuterParentheses("((())())"));
    }
}
