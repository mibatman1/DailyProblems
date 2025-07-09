package dailyproblems.twopointer;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveZeroWithReturnArray {
    public ArrayList<Integer> maxone(List<Integer> A, int B) 
    {
        int r=0, l=0, z=0, len=0, bl=0;
        while(r<A.size())
        {
            if(A.get(r)==0)
            {
                z++;
            }
            if(z>B)
            {
                if(A.get(l)==0)
                {
                    z--;
                }
                l++;
            }
            if((r-l+1)>len)
            {
                len=r-l+1;
                bl=l;
            }
            r++;
        }
        ArrayList<Integer>ls=new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            ls.add(i+bl);
        }
        return ls;
    }

    public static void main(String[] args) {
        MaxConsecutiveZeroWithReturnArray maxConsecutiveZeroWithReturnArray=new MaxConsecutiveZeroWithReturnArray();
        List<Integer>ls=List.of(1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1);
        int B=7;
        System.out.println(maxConsecutiveZeroWithReturnArray.maxone(ls, B));
    }
}
