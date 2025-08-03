package dailyproblems.twopointerlatest;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>st=new HashSet<>();
        Set<Integer>st2=new HashSet<>();
        for(var i:nums1)
            st.add(i);
        for(var i:nums2)
        {
            if(st.contains(i))
                st2.add(i);
        }
        int j=0;
        int arr[]=new int[st2.size()];
        for(var i:st2)
            arr[j++]=i;
        return arr;
    }

    public static void main(String[] args) {
        
    }
}
