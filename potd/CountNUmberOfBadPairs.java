package dailyproblems.potd;

import java.util.HashMap;
import java.util.Map;

public class CountNUmberOfBadPairs 
{
    public long countBadPairs(int[] nums) {
        Map<Integer, Long>mp=new HashMap<>();
        return solve(nums, mp);
    }

    //A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
    long solve(int nums[], Map<Integer, Long>mp)
    {
        long totalPair=((nums.length)*(nums.length-1))/2;
        for(int i=0;i<nums.length;i++)
        {
            int diff=nums[i]-i;
            totalPair-=mp.getOrDefault(diff, 0L);
            mp.put(diff, mp.getOrDefault(diff, 0L)+1);
        }
        return totalPair;
    }

    public static void main(String[] args) {
        int arr[]={4,1,3,3};
        CountNUmberOfBadPairs countNUmberOfBadPairs=new CountNUmberOfBadPairs();
        System.out.println(countNUmberOfBadPairs.countBadPairs(arr));
    }
}
