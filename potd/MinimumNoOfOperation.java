package potd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/?envType=daily-question&envId=2025-01-06
public class MinimumNoOfOperation {
    public int[] minOperations(String boxes) {
        List<Integer>res=new ArrayList<>();
        int ans[]=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++)
        {
            if(boxes.charAt(i)=='1')
            {
                res.add(i);
            }
        }
        for(int i=0;i<boxes.length();i++)
        {
            int c=0;
            for(var it:res)
            {
                c+=Math.abs(it-i);
            }
            ans[i]=c;
        }
        return ans;
    }
}
