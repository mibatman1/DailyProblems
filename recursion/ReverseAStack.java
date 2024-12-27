package recursion;

import java.util.Stack;

public class ReverseAStack 
{
    static void reverse(Stack<Integer> s)
    {
        if(s.size()==0)
            return;
        int temp=s.pop();
        reverse(s);
        insert(s, temp);
    }

    static void insert(Stack<Integer>st, int ele)
    {
        if(st.size()==0)
        {
            st.push(ele);
            return;
        }
        int temp=st.pop();
        insert(st, ele);
        st.push(temp);
    }
}
