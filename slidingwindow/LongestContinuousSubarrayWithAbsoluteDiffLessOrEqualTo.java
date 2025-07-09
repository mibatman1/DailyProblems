package dailyproblems.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessOrEqualTo {

    public int longestSubarray(int[] nums, int limit) {
        
        int r=0, l=0, len=0;
        Deque<Integer>inc=new LinkedList<>();
        Deque<Integer>dec=new LinkedList<>();
        while(r<nums.length)
        {
            while(inc.size()>0 && nums[r]<inc.getLast())
            {
                inc.removeLast();
            }
            inc.add(nums[r]);

            while(dec.size()>0 && nums[r]>dec.getLast())
            {
                dec.removeLast();
            }
            dec.add(nums[r]);

            if(dec.getFirst()-inc.getFirst()>limit)
            {
                if(nums[l]==dec.getFirst())
                    dec.removeFirst();

                if(nums[l]==inc.getFirst())
                    inc.removeFirst();
                l++;
            }
            len=Math.max(len, r-l+1);
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        
    }
    
}
