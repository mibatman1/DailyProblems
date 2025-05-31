package dailyproblems.recursion;

import java.util.Stack;

public class DeleteMiddleElementFromAStack 
{
    public void deleteMid(Stack<Integer> s) 
    {
        int midPos=(s.size()+1)/2;
        midDelete(s, midPos);
        System.out.println(s.toString());
    }

    void midDelete(Stack<Integer>st, int midPos)
    {
        if(midPos==1)
        {
            st.pop();
            return;
        }
        int temp=st.pop();
        midDelete(st, midPos-1);
        st.push(temp);
    }
}
