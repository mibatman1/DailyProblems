package dailyproblems.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArraySum 
{
    long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N)
    {
        int sum=0, max=Integer.MIN_VALUE, i=0, j=0;
        while(j<Arr.size())
        {
            sum+=Arr.get(j);
            if(j-i+1==N)
            {
                max=Math.max(max, sum);
                sum-=Arr.get(i);
                j++;
                i++;
            }
            else
            {
                j++;
            } 
        }
        return max;        
    }

    public static void main(String[] args) {
        MaxSubArraySum maxSubArraySum=new MaxSubArraySum();
        List<Integer>s=Arrays.asList(100, 200, 300, 400);
        ArrayList<Integer>ar=new ArrayList<>();
        ar.addAll(s);
        System.out.println(maxSubArraySum.maximumSumSubarray(4, ar, 2));
    }
}
