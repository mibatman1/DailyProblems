package potd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitwiseXOROfAllPairings 
{
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        Map<Integer, Integer>freq=new HashMap<>();
        for(var it:nums1)
        {
            freq.put(it, freq.getOrDefault(it, 0)+nums2.length);
        }
        for(var it:nums2)
        {
            freq.put(it, freq.getOrDefault(it, 0)+nums1.length);
        }
        for(var it:freq.keySet())
        {
            if(it%2!=0)
            {
                ans^=it;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int a=2, b=2, c=2, d=2;
        System.out.println(a^b^c^d);
    }
}
