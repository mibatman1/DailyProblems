package stacksqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentis 
{
    public boolean isValid(String s) 
    {
        Deque<Character>st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(st.isEmpty())
                    return false;
                Character ch=st.pop();
                if(s.charAt(i)==')' && ch=='(' || s.charAt(i)==']' && ch=='[' || s.charAt(i)=='}' && ch=='{')
                    continue;
                return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentis s=new ValidParentis();
        String st="{}{}[{}](])";
        System.out.println(s.isValid(st));
    }
    
}
