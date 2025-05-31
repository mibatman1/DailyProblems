package dailyproblems.potd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountDaysWithoutMeeting 
{
    // Flat the array, sort it, run the loop till last element and count the number of element
    public int countDays(int days, int[][] meetings) {
        int count=0;
        List<Integer>ls=new ArrayList<>();
        for(var it:meetings)
            for(var i:it)
                ls.add(i);

        Collections.sort(ls);
        for(var i=1;i<=days;i++)
        {
            if(ls.get(i)!=i)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[][]={{5,7},{1,3},{9,10}};
        CountDaysWithoutMeeting countDaysWithoutMeeting=new CountDaysWithoutMeeting();
        System.out.println(countDaysWithoutMeeting.countDays(5, arr));
    }
}
