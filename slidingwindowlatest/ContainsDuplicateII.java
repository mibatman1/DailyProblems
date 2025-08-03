package dailyproblems.slidingwindowlatest;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer>st=new HashSet<>();
        for(var i=0;i<nums.length;i++)
        {
            if(st.contains(nums[i]))
                return true;
            st.add(nums[i]);
            if(st.size()>k)
                st.remove(nums[i-k]);
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
