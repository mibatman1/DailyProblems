package dailyproblems.potd;

import java.util.PriorityQueue;

public class MinimumOperationToExceedThresoldValue 
{
    public int minOperations(int[] nums, int k) 
    {
        int res=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        while(pq.peek()<k)
        {
            var x=pq.poll();
            var y=pq.poll();
            pq.add(Math.min(x, y) * 2 + Math.max(x, y));
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumOperationToExceedThresoldValue solution = new MinimumOperationToExceedThresoldValue();

        int[] nums = {2,11,10,1,3};
        int k = 10;

        int result = solution.minOperations(nums, k);
        System.out.println("Minimum operations required: " + result);
    }
}
