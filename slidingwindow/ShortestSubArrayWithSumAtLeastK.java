package dailyproblems.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubArrayWithSumAtLeastK {

    public int shortestSubarray(int nums[], int targetSum)
    {
        long prefixSums[]=new long[nums.length+1];

        Deque<Integer>dq=new LinkedList<>();
        int r=0, len=Integer.MAX_VALUE;

        while(r<nums.length)
        {
            if(r==0)
            {
                prefixSums[r]=nums[r];
            }
            else
            {
                prefixSums[r]=prefixSums[r-1]+nums[r];
            }

            if(prefixSums[r]>=targetSum)
                len=Math.min(len, r+1);

            while(!dq.isEmpty() && prefixSums[r]-prefixSums[dq.peekFirst()]>=targetSum)
            {
                len=Math.min(len, r-dq.pollFirst());
            }

            while(prefixSums[r]<=prefixSums[dq.peekLast()])
            {
                dq.pollLast();
            }

            dq.addLast(r);

            r++;
        }
        return len==Integer.MAX_VALUE?-1:len;
    }

    public static void main(String[] args) {
        
    }
}
