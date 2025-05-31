package dailyproblems.stacksqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NextSmallerElement 
{
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) 
    {
        ArrayList<Integer>res=new ArrayList<>();
        int len=A.size();
        Deque<Integer>s=new ArrayDeque<>();
        for(int i=0;i<(len*2-1);i++)
        {
            while(!s.isEmpty() && s.peek()>=A.get(i%len))
            {
                s.pop();
            }
            if(i<len)
            {
                if(s.isEmpty())
                {
                    res.add(i%len,-1);
                }
                else
                {
                    res.add(i%len,s.peek());
                }
            }
            s.push(A.get(i%len));
        }
        return res;
    }

    public static void main(String[] args) {
        NextSmallerElement n=new NextSmallerElement();
        ArrayList<Integer>e=new ArrayList<>();
        e.add(4);
        e.add(5);
        e.add(2);
        e.add(10);
        e.add(8);
        ArrayList<Integer>er=n.prevSmaller(e);
        System.out.println(er);
    }
}
