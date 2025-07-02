package dailyproblems.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PairWithGivenDifference {

    public int solve(ArrayList<Integer> A, int B) 
    {
        Collections.sort(A);
        int s=0, e=A.size()-1;
        while(s<=e)
        {
            if(A.get(s)-A.get(e)==B)
            {
                return 1;
            }
            else if(A.get(s)-A.get(e)>B)
            {
                e--;
            }else
            {
                s++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
