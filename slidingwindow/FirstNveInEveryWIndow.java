package dailyproblems.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FirstNveInEveryWIndow 
{
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        List<Long>temp=new ArrayList<>();
        int i=0,j=0;
        Queue<Long>q=new ArrayDeque<>();
        while(j<A.length)
        {
            if(A[j]<0)
            {
                System.out.println(A[j]);
                q.add(A[j]);
                j++;
                System.out.println(q);
            }
            else if(j-i+1==K)
            {
                if(q.size()==0)
                {
                    temp.add(0L);
                }
                else
                {
                    temp.add(q.poll());
                }
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        long res[]=new long[temp.size()];
        for(int o=0;o<temp.size();o++)
        {
            res[o]=temp.get(o);
            System.out.println(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        long p[]={12, -1, -7, 8, -15, 30, 16, 28};
        FirstNveInEveryWIndow firstNveInEveryWIndow=new FirstNveInEveryWIndow();
        long res[]=firstNveInEveryWIndow.printFirstNegativeInteger(p, 8, 3);
        //System.out.println(res);
    }
}
