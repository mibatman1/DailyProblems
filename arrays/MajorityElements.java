package dailyproblems.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements 
{
    public int majorityElement(int[] nums) 
    {
        int n=nums.length;
        Map<Integer, Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i], 0)+1);
        }
        n/=2;
        for(var a:mp.entrySet())
        {
            if(a.getValue()>n)
                return a.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElements majorityElements=new MajorityElements();
        int arr[]={1,1,2,2,3,4,1,1,5,3,8};
        System.out.println(majorityElements.majorityElement(arr));        
    }
}
